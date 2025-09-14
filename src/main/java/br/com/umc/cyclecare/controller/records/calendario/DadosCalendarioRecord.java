package br.com.umc.cyclecare.controller.records.calendario;

import java.time.LocalDate;
import java.util.List;

public record DadosCalendarioRecord(LocalDate dataInicio,
                                    LocalDate dataFim,
                                    Long usuariaId,
                                    List<DadosCicloRecord> diasDoCiclo) {
}
