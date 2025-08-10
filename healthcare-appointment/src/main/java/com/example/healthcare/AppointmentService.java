package com.example.healthcare;

import java.time.LocalDate;

public class AppointmentService {
    private DoctorRepository doctorRepository;

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public String book(String doctorId, String date) {
        LocalDate appointmentDate = LocalDate.parse(date);
        if (doctorRepository.isDoctorAvailable(doctorId, appointmentDate)) {
            return "Appointment confirmed";
        }
        return "Doctor not available";
    }
}
