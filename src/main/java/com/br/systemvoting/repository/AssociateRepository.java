package com.br.systemvoting.repository;

import com.br.systemvoting.domain.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, Long> {
    
    Optional<Associate> findByCpf(String cpf);

}
