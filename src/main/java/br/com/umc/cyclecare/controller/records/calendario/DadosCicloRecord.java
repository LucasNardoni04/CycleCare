package br.com.umc.cyclecare.controller.records.calendario;

import br.com.umc.cyclecare.model.Fluxo;

public record DadosCicloRecord(String sintoma,
                               Fluxo fluxo,
                               String observacao) {
}
