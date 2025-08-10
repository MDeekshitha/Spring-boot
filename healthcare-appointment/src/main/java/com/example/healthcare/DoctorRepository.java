package com.example.healthcare;

import java.time.LocalDate;
import java.util.*;

public class DoctorRepository {
    private Map<String, List<LocalDate>> doctorSchedule = new HashMap<>();

    public DoctorRepository() {
        doctorSchedule.put("DOC101", Arrays.asList(
                LocalDate.of(2025, 4, 10),
                LocalDate.of(2025, 4, 12)
        ));
        doctorSchedule.put("DOC102", Arrays.asList(
                LocalDate.of(2025, 4, 11),
                LocalDate.of(2025, 4, 13)
        ));
    }

    public boolean isDoctorAvailable(String doctorId, LocalDate date) {
        return doctorSchedule.containsKey(doctorId) &&
                doctorSchedule.get(doctorId).contains(date);
    }
}
