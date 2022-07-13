package com.example.actividad_clase.service;

import com.example.actividad_clase.model.Cancione;

import java.util.List;

public interface CancionService {

    public Cancione create(Cancione c);
    public Cancione save(Cancione casa);
    public  Cancione findById(Integer id);
    public List<Cancione> findByAll();
    public void eliminar(Integer id);

}
