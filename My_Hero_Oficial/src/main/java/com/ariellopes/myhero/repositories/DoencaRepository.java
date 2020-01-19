package com.ariellopes.myhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariellopes.myhero.domain.Doenca;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Integer>{

}
