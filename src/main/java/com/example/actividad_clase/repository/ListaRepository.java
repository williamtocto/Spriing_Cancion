package com.example.actividad_clase.repository;



import com.example.actividad_clase.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Integer> {
}
