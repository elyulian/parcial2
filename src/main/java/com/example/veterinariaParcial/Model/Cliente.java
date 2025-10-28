package com.example.veterinariaParcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    @Column(name = "nombre", length = 120, nullable = false)
    private String nombre;
    @Column(name = "documento", length = 40, nullable = false, unique = true)
    private String documento;
    @Column(name = "telefono", length = 40)
    private String telefono;
    @Column(name = "correo", length = 120)
    private String correo;
    @Column(name = "direccion", length = 160)
    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Mascota> mascotas;
}
