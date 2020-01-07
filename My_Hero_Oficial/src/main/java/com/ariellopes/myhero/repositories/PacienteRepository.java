package com.ariellopes.myhero.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ariellopes.myhero.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

	Optional<Paciente> findByCpf(String cpf);
}
