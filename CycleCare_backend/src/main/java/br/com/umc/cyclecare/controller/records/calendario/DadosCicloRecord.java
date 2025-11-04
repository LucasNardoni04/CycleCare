package br.com.umc.cyclecare.controller.records.calendario;

import br.com.umc.cyclecare.model.Fluxo;

import java.time.LocalDate;

public record DadosCicloRecord(String sintoma,
                               Fluxo fluxo,
                               LocalDate dataInicio,
                               LocalDate dataFim,
                               String observacao) {
}
