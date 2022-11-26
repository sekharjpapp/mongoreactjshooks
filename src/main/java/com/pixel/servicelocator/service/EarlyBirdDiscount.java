package com.pixel.servicelocator.service;

import org.springframework.stereotype.Component;

@Component
public class EarlyBirdDiscount implements Discountable{
    @Override
    public String discountable(ShoppingCart shoppingCart) {
        return shoppingCart.getTimeOfCheckout() +" " + shoppingCart.getCartTotal();
    }

    @Override
    public double getDiscount() {
        return 0.25D;
    }
}
