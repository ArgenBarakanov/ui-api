package com.argen.uiapi.rest;

import com.argen.uiapi.dto.Category;
import com.argen.uiapi.dto.TestDataFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@Slf4j
public class UserController {

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<Category>> getAllUsers() {
        TestDataFactory testDataFactory = new TestDataFactory();
        return new ResponseEntity<>(testDataFactory.generateCategory(), HttpStatus.OK);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
