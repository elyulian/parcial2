package com.example.veterinariaParcial.Controller;

import com.example.veterinariaParcial.Model.Cliente;
import com.example.veterinariaParcial.Model.Mascota;
import com.example.veterinariaParcial.Service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {
    @Autowired
    public MascotaService mascotaService;

    @PostMapping("/guardar")
    public ResponseEntity<Mascota> crear(@RequestBody Mascota mascota) {
        mascotaService.guardar(mascota);
        return ResponseEntity.created(null).body(mascota);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Mascota>> obtenerTodos() {
        return ResponseEntity.ok(mascotaService.listar());
    }

    @DeleteMapping("/eliminar/{idMascota}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idMascota) {
        mascotaService.eliminar(idMascota);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/obtener/{idMascota}")
    public ResponseEntity<Mascota> obtenerPorId(@PathVariable Long idMascota) {
        return mascotaService.obtenerPorId(idMascota)
                .map(mascota -> ResponseEntity.ok().body(mascota))
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/porClienteDocumento/{documento}")
    public ResponseEntity<List<Mascota>> mascotasPorClienteDocumento(@RequestParam String documento) {
        return ResponseEntity.ok(mascotaService.mascotasPorClienteDocumento(documento));
    }
    @GetMapping("/totalPorEspecie")
    public ResponseEntity<List<Object[]>> totalMascotasPorEspecie() {
        return ResponseEntity.ok(mascotaService.totalMascotasPorEspecie());
    }
}
