package com.example.actividad_clase.controller;


import com.example.actividad_clase.model.Cancione;
import com.example.actividad_clase.model.Lista;
import com.example.actividad_clase.service.CancionService;
import com.example.actividad_clase.service.ListaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cancion")
public class CancionController {

    @Autowired
    CancionService cancionService;

    @Autowired
    ListaServiceImpl listaService;


    @GetMapping("/listar")
    public ResponseEntity<List<Cancione>> listar() {
        List<Cancione> lista= cancionService.findByAll();
        if (lista.size()==0){
            return new ResponseEntity<>(lista, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("/crear/{id}")
    public ResponseEntity<Cancione> crearCancion(@RequestBody Cancione u, @PathVariable Integer id ) {

        u.setLista(listaService.findById(id));
        return new ResponseEntity<>(cancionService.create(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Cancione> eliminarCancion(@PathVariable Integer id) {
        cancionService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/actualizar/{id}/{id_lista}")
    public ResponseEntity<Cancione> actulizarCancion(@PathVariable Integer id,@PathVariable Integer id_lista, @RequestBody Cancione c) {
        Cancione listaActual=cancionService.findById(id);
        c.setLista(listaService.findById(id_lista));
        listaActual.setLista(c.getLista());
        listaActual.setAlbum(c.getAlbum());
        listaActual.setTitulo(c.getTitulo());
        listaActual.setArtista(c.getArtista());
        listaActual.setAnio(c.getAnio());
        cancionService.save(listaActual);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
