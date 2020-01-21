package com.ariellopes.myhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariellopes.myhero.domain.ContatoDeEmergencia;

@Repository
public interface ContatoDeEmergenciaRepository extends JpaRepository<ContatoDeEmergencia, Integer> {

}
