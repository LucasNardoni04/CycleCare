package br.com.umc.cyclecare.controller;

import br.com.umc.cyclecare.controller.records.user.LoginRequestRecord;
import br.com.umc.cyclecare.controller.records.user.RegisterRequestRecord;
import br.com.umc.cyclecare.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestRecord body) {
        return ResponseEntity.ok(authService.login(body));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@Valid @RequestBody RegisterRequestRecord body) {
        return ResponseEntity.ok(authService.cadastrar(body));
    }
}
