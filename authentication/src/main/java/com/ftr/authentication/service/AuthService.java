package com.ftr.authentication.service;

import com.ftr.authentication.DTO.UserLoginDTO;
import com.ftr.authentication.DTO.UserRegisterDTO;
import com.ftr.authentication.enums.Role;
import com.ftr.authentication.model.User;
import com.ftr.authentication.response.TokenResponse;
import com.ftr.authentication.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

        if(userService.findUserByEmail(userRegisterDTO.getEmail())){
            throw new RuntimeException("User with email already exists");
        }

        User user = new User();
        user.setName(userRegisterDTO.getName());
        user.setRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));
        user.setEmail(userRegisterDTO.getEmail());
        userService.saveUser(user);
    }

    public TokenResponse loginUser(UserLoginDTO userLoginDTO) {
       Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword())
        );
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        //----------------------------------
        System.out.println("role: " + role);

//






    }
}
