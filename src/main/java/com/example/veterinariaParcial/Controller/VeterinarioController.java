package com.example.veterinariaParcial.Controller;

import com.example.veterinariaParcial.Model.Mascota;
import com.example.veterinariaParcial.Model.Veterinario;
import com.example.veterinariaParcial.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinario")
public class VeterinarioController {
    @Autowired
    public VeterinarioService veterinarioService;

    @PostMapping("/guardar")
    public ResponseEntity<Veterinario> crear(@RequestBody Veterinario veterinario) {
        veterinarioService.guardar(veterinario);
        return ResponseEntity.created(null).body(veterinario);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Veterinario>> obtenerTodos() {
        return ResponseEntity.ok(veterinarioService.listar());
    }

    @DeleteMapping("/eliminar/{idVeterinario}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idVeterinario) {
        veterinarioService.eliminar(idVeterinario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/obtener/{idVeterinario}")
    public ResponseEntity<Veterinario> obtenerPorId(@PathVariable Long idVeterinario) {
        return veterinarioService.obtenerPorId(idVeterinario)
                .map(veterinario -> ResponseEntity.ok().body(veterinario))
                .orElse(ResponseEntity.notFound().build());
    }
}
