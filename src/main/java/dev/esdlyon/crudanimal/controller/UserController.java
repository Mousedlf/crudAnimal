package dev.esdlyon.crudanimal.controller;

import dev.esdlyon.crudanimal.entity.AuthRequest;
import dev.esdlyon.crudanimal.entity.UserInfo;
import dev.esdlyon.crudanimal.service.JwtService;
import dev.esdlyon.crudanimal.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserInfoService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserInfo user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/profile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/profile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generate/token")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = manager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

}
