package com.example.actividad_clase.service;


import com.example.actividad_clase.model.Cancione;
import com.example.actividad_clase.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CancioneServiceImpl implements CancionService {

    @Autowired
    CancionRepository cancioneRepository;

    @Override
    public Cancione create(Cancione c) {
        return cancioneRepository.save(c);
    }

    @Override
    public Cancione save(Cancione casa) {
        return cancioneRepository.save(casa);
    }

    @Override
    public Cancione findById(Integer id) {
        return cancioneRepository.findById(id).orElse(new Cancione());
    }

    @Override
    public List<Cancione> findByAll() {
        return cancioneRepository.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        cancioneRepository.deleteById(id);

    }
}
