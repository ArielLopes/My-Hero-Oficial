package com.ariellopes.myhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ariellopes.myhero.domain.LocalDeMoradia;

@Repository
public interface LocalDeMoradiaRepository extends JpaRepository<LocalDeMoradia, Integer> {

}
