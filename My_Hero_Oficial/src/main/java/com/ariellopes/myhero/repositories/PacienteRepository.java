package com.ariellopes.myhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariellopes.myhero.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}
