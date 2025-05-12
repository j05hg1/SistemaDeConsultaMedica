package com.sistconsulmedico.backend.service;

import com.sistconsulmedico.backend.model.Paciente;
import com.sistconsulmedico.backend.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio que maneja la lógica de negocio relacionada con los pacientes.
 * Utiliza el repositorio para acceder a los datos de la base de datos.
 * Se encarga de las operaciones CRUD y otras operaciones relacionadas con los pacientes.
 */
@Service
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    /**
     * Optional es una clase contenedora que puede o no contener un valor no nulo.
     * En este caso, se utiliza para manejar el caso en que no se encuentra un paciente con el ID dado.
     * Busca un paciente por su ID.
     */
    public Optional<Paciente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Paciente guardar(Paciente paciente) {
        return repository.save(paciente);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
