package com.example.actividad_clase.repository;

import com.example.actividad_clase.model.Cancione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancionRepository extends JpaRepository<Cancione, Integer> {

}