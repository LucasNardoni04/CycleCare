package br.com.umc.cyclecare.controller;

import br.com.umc.cyclecare.controller.records.user.DadosUserRecord;
import br.com.umc.cyclecare.model.User;
import br.com.umc.cyclecare.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Sucesso!");
    }
}
