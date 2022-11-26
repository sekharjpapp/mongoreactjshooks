package com.pixel.servicelocator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class DiscountProvider {

    @Autowired
    private EarlyBirdDiscount earlyBirdDiscount;

    @Autowired
    private NightOwlDiscount nightOwlDiscount;


    private boolean isEarlyMorning(int currentHour) {
        return (currentHour >=5 && currentHour <=9);
    }
    private boolean isLateNight(int currentHour) {
        return (currentHour >=0 && currentHour <=4);
    }

    public Discountable getHour() {
        int hour = LocalTime.now().getHour();

        if (isEarlyMorning(hour)) {
            return earlyBirdDiscount;
        }else if (isLateNight(hour)) {
            return nightOwlDiscount;
        }
        return new NoDiscount();
    }
}
