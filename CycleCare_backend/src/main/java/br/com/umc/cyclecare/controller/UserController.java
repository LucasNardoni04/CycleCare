package br.com.umc.cyclecare.controller;

import br.com.umc.cyclecare.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Sucesso!");
    }
}
