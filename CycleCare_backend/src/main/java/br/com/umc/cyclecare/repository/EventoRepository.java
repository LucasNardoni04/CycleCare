package br.com.umc.cyclecare.repository;

import br.com.umc.cyclecare.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByCicloId(Long ciclo_id);
}
