package com.example.healthcare;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("healthcare-context.xml");

        AppointmentService service = (AppointmentService) context.getBean("appointmentService");
        System.out.println(service.book("DOC101", "2025-04-10"));
        System.out.println(service.book("DOC101", "2025-04-15"));
    }
}
