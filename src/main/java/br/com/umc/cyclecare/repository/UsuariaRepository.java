package br.com.umc.cyclecare.repository;

import br.com.umc.cyclecare.model.Usuaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariaRepository extends JpaRepository<Usuaria, Long> {
}
