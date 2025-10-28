package com.example.veterinariaParcial.Service;

import com.example.veterinariaParcial.Model.Cita;
import com.example.veterinariaParcial.Repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    public CitaRepository citaRepository;

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    public void eliminar(Long idCita) {
        citaRepository.deleteById(idCita);
    }

    public Optional<Cita> obtenerPorId(Long idCita) {
        return citaRepository.findById(idCita);
    }
    public List<Cita> citasPorVeterinarioPendiente(Long idVeterinario) {
        return citaRepository.findCitasPendientes(idVeterinario);
    }
    public List<Cita> citaMascotasDetalle(Long idMascota) {
        return citaRepository.findCitasByMascota(idMascota);
    }
    public List<Object[]> veterinariosMasCitas() {
        return citaRepository.findVeterinariosMasCitas();
    }
}
