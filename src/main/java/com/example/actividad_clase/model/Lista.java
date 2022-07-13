package com.example.actividad_clase.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lista")
public class Lista {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 70)
    private String nombre;

    @Column(name = "descripcion", length = 70)
    private String descripcion;

    @OneToMany(mappedBy = "lista")
    private Set<Cancione> canciones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Cancione> getCanciones() {
        return canciones;
    }

    public void setCanciones(Set<Cancione> canciones) {
        this.canciones = canciones;
    }

}