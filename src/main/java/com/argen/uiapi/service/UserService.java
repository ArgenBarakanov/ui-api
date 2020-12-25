package com.argen.uiapi.service;

import com.argen.uiapi.dto.authentication.SignUp;
import com.argen.uiapi.entity.Role;
import com.argen.uiapi.entity.User;
import com.argen.uiapi.repository.RoleRepository;
import com.argen.uiapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.function.Supplier;

@Service
public class UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    public User findByLogin(String userName) throws Exception {
        return userRepository.findByUserName(userName)
                .orElseThrow(() -> new Exception("User Not Found"));
    }

    public void saveUser(SignUp signUp) {
        try {
            if (userRepository.findByUserName(signUp.username).isPresent())
                throw new Exception("User with such username already exists");
            Role role = roleRepository.findByName(signUp.role).orElseThrow(() -> new Exception("Role not Found"));
            User user = new User().setUserName(signUp.username)
                    .setPassword(signUp.password)
                    .setRole(role);
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
