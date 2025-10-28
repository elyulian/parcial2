package com.example.veterinariaParcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mascota;
    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;
    @Column(name = "especie", length = 40, nullable = false)
    private String especie;
    @Column(name = "raza", length = 80)
    private String raza;
    @Column(name = "sexo", length = 10)
    private String sexo;
    @Column(name = "fecha_nac")
    private String fecha_nac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @JsonIgnore
    private Cliente cliente;



}
