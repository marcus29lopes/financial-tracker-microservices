package com.ftr.authentication.authController;

import com.ftr.authentication.DTO.UserLoginDTO;
import com.ftr.authentication.DTO.UserRegisterDTO;
import com.ftr.authentication.response.TokenResponse;
import com.ftr.authentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        authService.registerUser(userRegisterDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponse login(@RequestBody UserLoginDTO userLoginDTO) {
        return authService.loginUser(userLoginDTO);
    }

}
