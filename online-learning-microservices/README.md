# Online Learning Microservices (No Docker)

This archive contains 3 Spring Boot microservices:
 - user-service (port 8081)
 - course-service (port 8082)
 - assessment-service (port 8083)

Each service uses MySQL (localhost:3306) and Kafka (localhost:9092).

## How to run
1. Make sure MySQL and Kafka are running locally.
2. Update `application.properties` for DB credentials.
3. Navigate to the service folder and run:
   ```
   mvn spring-boot:run
   ```
