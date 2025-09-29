package br.com.umc.cyclecare.controller;

import br.com.umc.cyclecare.controller.records.user.LoginRequestRecord;
import br.com.umc.cyclecare.controller.records.user.RegisterRequestRecord;
import br.com.umc.cyclecare.controller.records.user.ResponseRecord;
import br.com.umc.cyclecare.infra.security.TokenService;
import br.com.umc.cyclecare.model.User;
import br.com.umc.cyclecare.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestRecord body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseRecord(user.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping("/registrar")
    public ResponseEntity registrar(@Valid @RequestBody RegisterRequestRecord body){
        Optional<User> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            User newUser = new User();
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setEmail(body.email());
            newUser.setNome(body.nome());
            newUser.setTelefone((body.telefone()));
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseRecord(newUser.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
