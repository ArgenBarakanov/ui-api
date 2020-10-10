package com.argen.uiapi.rest;

import com.argen.uiapi.dto.authentication.SignIn;
import com.argen.uiapi.dto.authentication.SignUp;
import com.argen.uiapi.entity.Role;
import com.argen.uiapi.security.UserPrinciple;
import com.argen.uiapi.security.jwt.JwtProvider;
import com.argen.uiapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody SignUp signUp) {
        signUp.password = passwordEncoder.encode(signUp.password);
        userService.saveUser(signUp);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody SignIn signIn) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.username,signIn.password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        return new ResponseEntity<>(token,HttpStatus.OK);

    }


}
