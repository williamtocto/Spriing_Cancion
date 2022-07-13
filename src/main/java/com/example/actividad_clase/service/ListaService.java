package com.example.actividad_clase.service;


import com.example.actividad_clase.model.Lista;

import java.util.List;

public interface ListaService {

    public Lista create(Lista c);
    public Lista save(Lista casa);
    public Lista findById(Integer id);
    public List<Lista> findByAll();
    public void eliminar(Integer id);

}
