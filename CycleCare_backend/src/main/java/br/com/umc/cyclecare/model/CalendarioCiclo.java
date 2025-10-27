package br.com.umc.cyclecare.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "calendarios_ciclo")
public class CalendarioCiclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    @OneToMany(mappedBy = "calendarioCiclo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ciclo> diasDoCiclo;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
}