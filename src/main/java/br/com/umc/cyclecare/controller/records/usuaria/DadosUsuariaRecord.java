package br.com.umc.cyclecare.controller.records.usuaria;

public record DadosUsuariaRecord(Long id,
                                 String nome,
                                 String email,
                                 String telefone,
                                 String dataNascimento) {
}
