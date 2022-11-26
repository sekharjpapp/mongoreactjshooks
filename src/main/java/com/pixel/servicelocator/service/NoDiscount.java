package com.pixel.servicelocator.service;

public class NoDiscount implements Discountable {
    @Override
    public String discountable(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
