package com.example.airline;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirlineApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("airline-context.xml");

        TicketService ticketService = (TicketService) context.getBean("ticketService");
        System.out.println(ticketService.confirmBooking("FL123", "USER456"));
        System.out.println(ticketService.confirmBooking("FL123", "USER789"));
        System.out.println(ticketService.confirmBooking("FL123", "USER999"));
    }
}
