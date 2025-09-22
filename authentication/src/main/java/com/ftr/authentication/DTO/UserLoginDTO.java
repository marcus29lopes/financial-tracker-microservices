package com.ftr.authentication.DTO;

import lombok.Data;

@Data
public class UserLoginDTO {
    private String email;
    private String password;
}
