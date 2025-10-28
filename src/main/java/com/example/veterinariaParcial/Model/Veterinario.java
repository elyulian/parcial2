package com.example.veterinariaParcial.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_veterinario;
    @Column(name = "nombre", length = 120, nullable = false)
    private String nombre;
    @Column(name = "especialidad", length = 100)
    private String especialidad;
    @Column(name = "registro_profesional", length = 60, nullable = false, unique = true)
    private String registro_profesional;
}
