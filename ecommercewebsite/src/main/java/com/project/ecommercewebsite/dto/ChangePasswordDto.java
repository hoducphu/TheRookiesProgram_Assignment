package com.project.ecommercewebsite.dto;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordDto {
    @Length(min = 8, max = 16, message = "ACB")
    private String userpassword;

}
