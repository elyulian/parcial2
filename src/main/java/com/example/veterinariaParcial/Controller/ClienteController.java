package com.example.veterinariaParcial.Controller;

import com.example.veterinariaParcial.Model.Cliente;
import com.example.veterinariaParcial.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    public ClienteService clienteService;

    @PostMapping("/guardar")
    public ResponseEntity<Cliente> crear(@RequestBody Cliente cliente) {
        clienteService.guardar(cliente);
        return ResponseEntity.created(null).body(cliente);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> obtenerTodos() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @DeleteMapping("/eliminar/{idCliente}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCliente) {
        clienteService.eliminar(idCliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/obtener/{idCliente}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long idCliente) {
        return clienteService.obtenerPorId(idCliente)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }
}
