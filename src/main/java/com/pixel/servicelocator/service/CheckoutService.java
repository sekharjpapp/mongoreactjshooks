package com.pixel.servicelocator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class CheckoutService {

    @Autowired
    private NightOwlDiscount nightOwlDiscount;

    @Autowired
    private DiscountProvider discountProvider;

    public static String getHour() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        String str = "";
        if (hour == 4 || hour == 9 && minutes <= 0) {
            System.out.println("35 % discount" + str);
        } else if (hour == 10 || hour == 12 && minutes <= 40){
            System.out.println("25 % discount" + str);
        } else {
            System.out.println("No Discount ");
        }
        return str;
    }

    public double checkout(ShoppingCart cart) {
        final double discount = discountProvider.getHour().getDiscount();
        double total = 100.0D;

        double totalAfterDiscount = total - (total * discount);
        System.out.printf("%nShopping cart initially [$%.2f] with a discount of %.2f%% = [$%.2f]%n%n",
                total,
                discount * 100,
                totalAfterDiscount);
        return totalAfterDiscount;
    }
}
