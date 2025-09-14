package br.com.umc.cyclecare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ciclo")
public class Ciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sintoma;

    @Enumerated(EnumType.STRING)
    private Fluxo fluxo;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "calendario_ciclo_id", nullable = false)
    private CalendarioCiclo calendarioCiclo;
}
