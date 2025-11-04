package br.com.umc.cyclecare.service;

import br.com.umc.cyclecare.controller.records.calendario.DadosCicloRecord;
import br.com.umc.cyclecare.model.Ciclo;
import br.com.umc.cyclecare.model.User;
import br.com.umc.cyclecare.repository.CicloRepository;
import br.com.umc.cyclecare.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CicloService {

    private final CicloRepository cicloRepository;
    private final UserRepository userRepository;

    public Ciclo cadastrarCiclo(DadosCicloRecord body, User user) {

        Ciclo ciclo = Ciclo.builder()
                .dataInicio(body.dataInicio())
                .dataFim(body.dataFim())
                .sintoma(body.sintoma())
                .fluxo(body.fluxo())
                .user(user)
                .build();

        return cicloRepository.save(ciclo);
    }

}
