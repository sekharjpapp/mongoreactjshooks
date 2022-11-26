package com.pixel.controller;

import com.pixel.validator.CustomerValValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerValController {

    @Autowired
    private CustomerValValidator customerValValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
            webDataBinder.setValidator(customerValValidator);
    }


}
