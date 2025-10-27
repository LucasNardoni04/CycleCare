package br.com.umc.cyclecare.service;

import br.com.umc.cyclecare.controller.records.user.AuthUsuarioResponse;
import br.com.umc.cyclecare.controller.records.user.LoginRequestRecord;
import br.com.umc.cyclecare.controller.records.user.RegisterRequestRecord;
import br.com.umc.cyclecare.infra.security.TokenService;
import br.com.umc.cyclecare.model.User;
import br.com.umc.cyclecare.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthUsuarioResponse login(LoginRequestRecord body) {
        try {
            User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));

            if (passwordEncoder.matches(body.senha(), user.getSenha())) {
                return new AuthUsuarioResponse(user.getNome(), this.tokenService.generateToken(user));
            }
        } catch (Exception e) {
            throw new RuntimeException("Falha inesperada no login", e);
        }
        return null;
    }

    public AuthUsuarioResponse cadastrar(RegisterRequestRecord body) {
        try {
            Optional<User> user = this.repository.findByEmail(body.email());

            if (user.isEmpty()) {
                var newUser = User.builder()
                        .nome(body.nome())
                        .telefone(body.telefone())
                        .email(body.email())
                        .senha(body.senha())
                        .build();

                repository.save(newUser);
                var token = tokenService.generateToken(newUser);
                return new AuthUsuarioResponse(newUser.getNome(), token);
            }
            var token = tokenService.generateToken(user.get());
            return new AuthUsuarioResponse(user.get().getNome(), token);
        } catch (Exception e) {
            throw new RuntimeException("Falha inesperada no cadastro do usuario.", e);
        }
    }
}

