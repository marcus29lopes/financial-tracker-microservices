package com.ftr.authentication.service;

import com.ftr.authentication.DTO.UserLoginDTO;
import com.ftr.authentication.DTO.UserRegisterDTO;
import com.ftr.authentication.enums.Role;
import com.ftr.authentication.model.Users;
import com.ftr.authentication.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public void registerUser(UserRegisterDTO userRegisterDTO) {

        if (userService.findUserByEmail(userRegisterDTO.getEmail())) {
            throw new RuntimeException("User with email already exists");
        }

        Users users = new Users();
        users.setName(userRegisterDTO.getName());
        users.setRole(Role.ROLE_USER);
        users.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        users.setEmail(userRegisterDTO.getEmail());
        userService.saveUser(users);
    }

    public String loginUser(UserLoginDTO userLoginDTO) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword())
        );
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        return jwtUtil.generateToken(userDetails.getUsername(), role);


    }
}
