package br.com.umc.cyclecare.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarias")
public class Usuaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "usuaria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalendarioCiclo> calendarios;
}
