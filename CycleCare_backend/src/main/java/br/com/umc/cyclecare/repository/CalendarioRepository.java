package br.com.umc.cyclecare.repository;

import br.com.umc.cyclecare.model.CalendarioCiclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<CalendarioCiclo, Long> {
}
