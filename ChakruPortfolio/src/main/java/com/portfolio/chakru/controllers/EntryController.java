package com.portfolio.chakru.controllers;


import com.portfolio.chakru.Exception.PasswordException;
import com.portfolio.chakru.Exception.UserException;
import com.portfolio.chakru.models.Login;
import com.portfolio.chakru.models.UserModel;
import com.portfolio.chakru.models.dto.UserDTO;
import com.portfolio.chakru.service.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@RestController
@RequestMapping("/user")
@Log4j2
//@CrossOrigin(origins = {"${ANGULAR.url}"})
public class EntryController {
    private final LoginService loginService;

    @Autowired
    public EntryController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    ResponseEntity<UserDTO> login(@RequestBody Login userLogin) {
        try {
            UserDTO loggedInUser = loginService.validLogin(userLogin);
            if (Objects.nonNull(loggedInUser)) {
                return ResponseEntity.ok(loggedInUser);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (UserException | PasswordException e) {
            log.error("Crucial information for user mission {}", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup")
    ResponseEntity<UserDTO> signup(@RequestBody UserModel user) {
        try {
            UserDTO signedUpUser = loginService.signUpUser(user);
            if (Objects.nonNull(signedUpUser)) {
                return ResponseEntity.ok(signedUpUser);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (UserException e) {
            log.error("User object is invalid {}", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
