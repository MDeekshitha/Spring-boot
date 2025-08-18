# Healthcare Microservices (Spring Boot 3 + Spring Cloud)

### Services & Ports
- `service-registry` (Eureka) – 8761
- `api-gateway` – 8080 (auto routes via serviceId)
- `appointment-service` – 8081
- `doctor-service` – 8082
- `patient-service` – 8083
- `medical-records-service` – 8084
- `billing-service` – 8085
- `notification-service` – 8086

### Run order (each in its own terminal)
1. `mvn -q -DskipTests spring-boot:run -pl service-registry`
2. `mvn -q -DskipTests spring-boot:run -pl doctor-service`
3. `mvn -q -DskipTests spring-boot:run -pl patient-service`
4. `mvn -q -DskipTests spring-boot:run -pl notification-service`
5. `mvn -q -DskipTests spring-boot:run -pl appointment-service`
6. (optional) gateway, records, billing.

### Sample calls
Create doctor:
```
POST http://localhost:8082/doctors
{"name":"Dr. Rao","specialization":"Cardiology"}
```

Book appointment (blocks slot in Doctor Service, sends async notification):
```
POST http://localhost:8081/appointments
{"patientName":"Nishtha","doctorId":1,"dateTime":"2025-08-17T10:00:00"}
```

Cancel appointment (releases slot):
```
DELETE http://localhost:8081/appointments/1
```

### Notes
- All DBs are in-memory H2 for easy start.
- If anything fails after reserving the slot, Appointment Service compensates by releasing the slot.
- Notifications are fire-and-forget to `notification-service` to mimic async processing without external brokers.
