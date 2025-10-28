package com.example.veterinariaParcial.Service;

import com.example.veterinariaParcial.Model.Cliente;
import com.example.veterinariaParcial.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }
    public Optional<Cliente> obtenerPorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }
    public void eliminar(Long idCliente) {
        if (clienteRepository.existsById(idCliente)){
            clienteRepository.deleteById(idCliente);
            System.out.println("El cliente con ID " + idCliente + " ha sido eliminado.");

        } else {
            System.out.println("El cliente con ID " + idCliente + " no existe.");
        }
    }

}
