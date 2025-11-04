package br.com.umc.cyclecare.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDate dataHoraInicio;
    private LocalDate dataHoraFim;

    @ManyToOne
    @JoinColumn(name = "ciclo_id", referencedColumnName = "id", nullable = false)
    private Ciclo ciclo;
}
