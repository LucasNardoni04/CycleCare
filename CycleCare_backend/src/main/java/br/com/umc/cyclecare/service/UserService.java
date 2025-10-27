package br.com.umc.cyclecare.service;

import br.com.umc.cyclecare.controller.records.user.DadosUserRecord;
import br.com.umc.cyclecare.model.User;
import br.com.umc.cyclecare.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User cadastraUser(DadosUserRecord record) {
        var user = User.builder()
                .nome(record.nome())
                .email(record.email())
                .telefone(record.telefone())
                .build();

        return repository.save(user);
    }
}
