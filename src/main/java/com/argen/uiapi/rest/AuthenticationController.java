package com.argen.uiapi.rest;

import com.argen.uiapi.dto.authentication.LoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<String> createUser(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto.username + " " + loginDto.password);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
