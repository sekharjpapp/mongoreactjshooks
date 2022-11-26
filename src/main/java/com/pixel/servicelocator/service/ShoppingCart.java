package com.pixel.servicelocator.service;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Data
@Component
public class ShoppingCart {

    private LocalTime timeOfCheckout = LocalTime.now();

    public static String getHour() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        String str = "";
        if (hour == 4 || hour == 9 && minutes <= 0) {
            System.out.println("35 % discount" + str);
        } else if (hour == 10 || hour == 11 && minutes <= 40){
            System.out.println("25 % discount" + str);
        } else {
            System.out.println("No Discount ");
        }
        return str;
    }

    LocalTime earlyBird = LocalTime.parse("05:30").plus(3, ChronoUnit.HOURS);
    LocalTime nightOwel = LocalTime.parse("23:00").plus(5, ChronoUnit.HOURS);

    private double cartTotal;
}
