package com.example.veterinariaParcial.Service;

import com.example.veterinariaParcial.Model.Mascota;
import com.example.veterinariaParcial.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {
    @Autowired
    public MascotaRepository mascotaRepository;

    public Mascota guardar(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }
    public List<Mascota> listar() {
        return mascotaRepository.findAll();
    }
    public Optional<Mascota> obtenerPorId(Long idMascota) {
        return mascotaRepository.findById(idMascota);
    }
    public void eliminar(Long idMascota) {
        mascotaRepository.deleteById(idMascota);
    }
    public List<Mascota> mascotasPorClienteDocumento(String documento) {
        return mascotaRepository.findMascotasByClienteDocumento(documento);
    }
    public List<Object[]> totalMascotasPorEspecie() {
        return mascotaRepository.countMascotasByEspecie();
    }
}
