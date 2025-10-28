package com.example.veterinariaParcial.Repository;

import com.example.veterinariaParcial.Model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query(value = """
                SELECT c
                FROM Cita c
                WHERE c.veterinario.id = :idVeterinario
                  AND c.estado = 'Programada'
                  AND c.fecha_hora >= NOW()
                ORDER BY c.fecha_hora
            """,nativeQuery = true)
    List<Cita> findCitasPendientes(@Param("idVeterinario") Long idVeterinario);

    // 4. Citas de una mascota con detalle
    @Query(value = """
                SELECT c
                FROM Cita c
                JOIN FETCH c.veterinario v
                WHERE c.mascota.id = :idMascota
                ORDER BY c.fecha_hora DESC
            """,nativeQuery = true)
    List<Cita> findCitasByMascota(@Param("idMascota") Long idMascota);

    // 5. Veterinarios que más citas han atendido
    @Query(value = """
                SELECT c.veterinario.nombre, COUNT(c)
                FROM Cita c
                WHERE c.estado = 'Atendida'
                GROUP BY c.veterinario.nombre
                ORDER BY COUNT(c) DESC
            """,nativeQuery = true)
    List<Object[]> findVeterinariosMasCitas();
}

