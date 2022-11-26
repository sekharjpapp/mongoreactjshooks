package com.pixel.servicelocator;

import com.pixel.servicelocator.service.CheckoutService;
import com.pixel.servicelocator.service.EarlyBirdDiscount;
import com.pixel.servicelocator.service.NightOwlDiscount;
import com.pixel.servicelocator.service.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalTime;

@SpringBootApplication
public class DynamicAutoWireApp {
    @Autowired
    private NightOwlDiscount nightOwlDiscount;
    @Autowired
    private EarlyBirdDiscount earlyBirdDiscount;

    public static void main(String[] args) {
      ConfigurableApplicationContext ctx =  SpringApplication.run(DynamicAutoWireApp.class,args);
        ShoppingCart shoppingCart = ctx.getBean(ShoppingCart.class);
        NightOwlDiscount nightOwlDiscount = ctx.getBean(NightOwlDiscount.class);
        String store = "";
        EarlyBirdDiscount earlyBirdDiscount = ctx.getBean(EarlyBirdDiscount.class);
        LocalTime timeOfCheckout = shoppingCart.getTimeOfCheckout();
         double cartTotal = shoppingCart.getCartTotal();
        cartTotal = 100.0D;
        store = "Amount :: " + cartTotal + "  LocalTime now :: " +timeOfCheckout;
        System.out.println(store);
        nightOwlDiscount.discountable(new ShoppingCart());
        System.out.println(nightOwlDiscount.getDiscount());
        CheckoutService checkoutService = ctx.getBean(CheckoutService.class);
        checkoutService.checkout(new ShoppingCart());
        System.out.println(ShoppingCart.getHour());
    }
}
