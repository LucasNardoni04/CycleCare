package br.com.umc.cyclecare.service;

import br.com.umc.cyclecare.controller.records.usuaria.DadosUsuariaRecord;
import br.com.umc.cyclecare.model.Usuaria;
import br.com.umc.cyclecare.repository.UsuariaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuariaService {

    private final UsuariaRepository repository;

    public Usuaria cadastraUsuaria(DadosUsuariaRecord record) {
        var usuaria = Usuaria.builder()
                .nome(record.nome())
                .email(record.email())
                .telefone(record.telefone())
                .build();

        return repository.save(usuaria);
    }
}
