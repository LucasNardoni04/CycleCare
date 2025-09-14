package br.com.umc.cyclecare.model;

import lombok.Getter;

@Getter
public enum Fluxo {

    FORTE("Forte"),
    FRACO("Fraco"),
    MODERADO("Moderado");

    private String descricao;

    Fluxo(String descricao) {
        this.descricao = descricao;
    }

}
