package com.argen.uiapi.service;

import com.argen.uiapi.dto.authentication.UserCreateDto;
import com.argen.uiapi.entity.Role;
import com.argen.uiapi.entity.User;
import com.argen.uiapi.repository.RoleRepository;
import com.argen.uiapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public void saveUser(UserCreateDto userCreateDto) throws Exception {
        Role role = roleRepository.findByName(userCreateDto.role).orElseThrow(() -> new Exception("Role not Found"));
        User user = new User().setUserName(userCreateDto.userName)
                .setPassword(userCreateDto.password)
                .setRole(role);
        userRepository.save(user);
    }
}
