package com.dyvr.librarysystem.Library.System.Controllers;

import com.dyvr.librarysystem.Library.System.dao.RoleRepository;
import com.dyvr.librarysystem.Library.System.dao.UserRepository;
import com.dyvr.librarysystem.Library.System.model.RegisterRequest;
import com.dyvr.librarysystem.Library.System.model.Role;
import com.dyvr.librarysystem.Library.System.model.User;
import com.dyvr.librarysystem.Library.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class AuthenticationController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/library/registerUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
        try {
            if (userRepository.existsByUsername(registerRequest.getUsername())) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            User user = new User();
            user.setUsername(registerRequest.getUsername());
            user.setPassword(passwordEncoder().encode(registerRequest.getPassword()));

            Set<Role> roles = registerRequest.getRoles().stream()
                    .map(roleType -> roleRepository.findByName(roleType)
                            .orElseThrow(() -> new RuntimeException("Role not found: " + roleType)))
                    .collect(Collectors.toSet());

            user.setRoles(roles);
            userRepository.save(user);

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
