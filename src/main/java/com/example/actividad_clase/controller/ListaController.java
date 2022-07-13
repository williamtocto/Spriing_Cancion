package com.example.actividad_clase.controller;

import com.example.actividad_clase.model.Lista;
import com.example.actividad_clase.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lista")
public class ListaController {

    @Autowired
    ListaService listaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Lista>>listar() {
        List<Lista> lista=listaService.findByAll();
        if (lista.size()==0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Lista> crearLista(@RequestBody Lista u) {
        if (u.getNombre().equals("")){
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(listaService.create(u), HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Lista> eliminarLista(@PathVariable Integer id) {
        listaService.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


   @PutMapping("/actualizar/{id}")
    public ResponseEntity<Lista> actualizarLista(@PathVariable Integer id, @RequestBody Lista c) {

        Lista listaActual=listaService.findById(id);
        if (listaActual.getNombre().equals("")){
            listaActual.setDescripcion(c.getDescripcion());
            listaService.save(listaActual);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}



