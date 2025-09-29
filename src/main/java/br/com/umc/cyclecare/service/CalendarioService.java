package br.com.umc.cyclecare.service;

import br.com.umc.cyclecare.controller.records.calendario.DadosCalendarioRecord;
import br.com.umc.cyclecare.controller.records.calendario.DadosCicloRecord;
import br.com.umc.cyclecare.model.CalendarioCiclo;
import br.com.umc.cyclecare.model.Ciclo;
import br.com.umc.cyclecare.repository.CalendarioRepository;
import br.com.umc.cyclecare.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CalendarioService {

    private final CalendarioRepository calendarioRepository;
    private final UserRepository userRepository;

    public CalendarioCiclo cadastrarCalendarioCiclo(DadosCalendarioRecord record) {

        var user = userRepository.getReferenceById(record.usuariaId());

        var calendario = CalendarioCiclo.builder()
                .dataInicio(record.dataInicio())
                .dataFim(record.dataFim())
                .user(user)
                .build();

        List<Ciclo> ciclos = montaCiclos(record.diasDoCiclo());
        for (Ciclo ciclo : ciclos) {
            ciclo.setCalendarioCiclo(calendario);
        }

        calendario.setDiasDoCiclo(ciclos);

        return calendarioRepository.save(calendario);
    }

    private List<Ciclo> montaCiclos(List<DadosCicloRecord> dados) {
        return dados.stream().
                map(dia -> new Ciclo(
                        null,
                        dia.sintoma(),
                        dia.fluxo(),
                        dia.observacao(),
                        null
                ))
                .toList();

    }
}
