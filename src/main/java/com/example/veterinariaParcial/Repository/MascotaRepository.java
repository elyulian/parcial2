package com.example.veterinariaParcial.Repository;

import com.example.veterinariaParcial.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    @Query(value = """
        SELECT m
        FROM Mascota m
        JOIN m.cliente c
        WHERE c.documento = :documento
    """,nativeQuery = true)
    List<Mascota> findMascotasByClienteDocumento(@Param("documento") String documento);
    @Query(value = """
        SELECT m.especie, COUNT(m)
        FROM Mascota m
        GROUP BY m.especie
    """,nativeQuery = true)
    List<Object[]> countMascotasByEspecie();
}
