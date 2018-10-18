package com.tarea2.paises_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.tarea2.paises_app.entity.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}