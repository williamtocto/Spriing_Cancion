package com.example.actividad_clase.service;

import com.example.actividad_clase.model.Lista;
import com.example.actividad_clase.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaServiceImpl implements ListaService {

    @Autowired
    ListaRepository listaRepository;

    @Override
    public Lista create(Lista l) {
        return listaRepository.save(l);
    }

    @Override
    public Lista save(Lista l) {
        return listaRepository.save(l);
    }

    @Override
    public Lista findById(Integer id) {
        return listaRepository.findById(id).orElse(new Lista());
    }

    @Override
    public List<Lista> findByAll() {
        return listaRepository.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        listaRepository.deleteById(id);
    }

}
