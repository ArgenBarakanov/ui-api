package com.argen.uiapi.rest;

import com.argen.uiapi.dto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {

    @GetMapping("/all")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<PersonDto>> getAllUsers() {
        List<PersonDto> players = new ArrayList<>();
        players.add(new PersonDto().setName("Frank").setLastName("Lampard").setAbout("Midfield"));
        players.add(new PersonDto().setName("John").setLastName("Terry").setAbout("Defender"));
        players.add(new PersonDto().setName("Petr").setLastName("Cech").setAbout("Goalkeeper"));
        players.add(new PersonDto().setName("Didier").setLastName("Drogba").setAbout("Striker"));
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
