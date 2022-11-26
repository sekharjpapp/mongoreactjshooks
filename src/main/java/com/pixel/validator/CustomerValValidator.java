package com.pixel.validator;

import com.pixel.entity.CustomerVal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerValValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerVal customerVal = (CustomerVal) target;
        int age = customerVal.getAge();
        String password = customerVal.getPassword();
        String confPassword = customerVal.getConfPassword();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"age","customer.age.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"emailId","customer.emailId.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","customer.password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confPassword","customer.confPassword.empty");
        if (!password.equals(confPassword)) {
            errors.rejectValue("password","customer.password.mismatch");
        }
        if (age < 18 || age > 60) {
            errors.rejectValue("age","customer.age.range.invalid");
        }
    }
}
