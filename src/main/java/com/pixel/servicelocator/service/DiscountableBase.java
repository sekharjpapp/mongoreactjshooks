package com.pixel.servicelocator.service;

public class DiscountableBase implements Discountable{

    @Override
    public String discountable(ShoppingCart shoppingCart) {
        return shoppingCart.getTimeOfCheckout() +" " + shoppingCart.getCartTotal();
    }

    @Override
    public double getDiscount() {
        return 0;
    }
}
