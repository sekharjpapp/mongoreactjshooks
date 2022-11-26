package com.pixel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerVal {

    @Id
    private String id;
    private String emailId;
    private String password;
    private String confPassword;
    private int age;
}
