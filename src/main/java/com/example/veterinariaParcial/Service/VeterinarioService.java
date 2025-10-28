package com.example.veterinariaParcial.Service;

import com.example.veterinariaParcial.Model.Veterinario;
import com.example.veterinariaParcial.Repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    @Autowired
    public VeterinarioRepository veterinarioRepository;

    public Veterinario guardar(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }
    public List<Veterinario> listar() {
        return veterinarioRepository.findAll();
    }
    public Optional <Veterinario> obtenerPorId(Long idVeterinario) {
        return veterinarioRepository.findById(idVeterinario);
    }
    public void eliminar(Long idVeterinario) {
        veterinarioRepository.deleteById(idVeterinario);
    }
}
