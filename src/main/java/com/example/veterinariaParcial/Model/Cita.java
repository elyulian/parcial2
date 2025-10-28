package com.example.veterinariaParcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cita;
    @Column(nullable = false)
    private LocalDateTime fecha_hora;
    @Column(name = "motivo", length = 160, nullable = false)
    private String motivo;
    @Column(name = "estado", length = 20, nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_mascota", nullable = false)
    @JsonIgnore
    private Mascota mascota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinario", nullable = false)
    @JsonIgnore
    private Veterinario veterinario;

}
