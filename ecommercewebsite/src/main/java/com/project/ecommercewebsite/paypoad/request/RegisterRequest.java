package com.project.ecommercewebsite.paypoad.request;

import java.util.Set;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    @NotBlank
    @Size(min = 6, max = 18)
    private String username;

    @NotBlank
    @Size(min = 6, max = 18)
    private String userpassword;

    @NotBlank
    @Size(min = 13, max = 50)
    private String email;

    private Set<String> role;

}
