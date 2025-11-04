package br.com.umc.cyclecare.repository;

import br.com.umc.cyclecare.model.Ciclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CicloRepository extends JpaRepository <Ciclo, Long> {
    List<Ciclo> findByUserId(Long user_id);
}
