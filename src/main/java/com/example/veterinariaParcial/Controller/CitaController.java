package com.example.veterinariaParcial.Controller;

import com.example.veterinariaParcial.Model.Cita;
import com.example.veterinariaParcial.Model.Mascota;
import com.example.veterinariaParcial.Service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
public class CitaController {

    @Autowired
    public CitaService citaService;

    @PostMapping("/guardar")
    public ResponseEntity<Cita> crear(@RequestBody Cita cita) {
        citaService.guardar(cita);
        return ResponseEntity.created(null).body(cita);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cita>> obtenerTodos() {
        return ResponseEntity.ok(citaService.listar());
    }

    @DeleteMapping("/eliminar/{idCita}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCita) {
        citaService.eliminar(idCita);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/obtener/{idCita}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long idCita) {
        return citaService.obtenerPorId(idCita)
                .map(cita -> ResponseEntity.ok().body(cita))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/citasPendientes/veterinario/{idVeterinario}")
    public ResponseEntity<List<Cita>> citasPorVeterinarioPendiente(@PathVariable Long idVeterinario) {
        return ResponseEntity.ok(citaService.citasPorVeterinarioPendiente(idVeterinario));
    }
    @GetMapping("/citasDetalle/mascota/{idMascota}")
    public ResponseEntity<List<Cita>> citaMascotasDetalle(@PathVariable Long idMascota) {
        return ResponseEntity.ok(citaService.citaMascotasDetalle(idMascota));
    }

    @GetMapping("/veterinariosMasCitas")
    public ResponseEntity<List<Object[]>> veterinariosMasCitas() {
        return ResponseEntity.ok(citaService.veterinariosMasCitas());
    }
}

