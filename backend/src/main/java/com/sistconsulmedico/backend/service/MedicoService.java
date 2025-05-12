package com.sistconsulmedico.backend.service;

import com.sistconsulmedico.backend.model.Medico;
import com.sistconsulmedico.backend.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio que maneja la lógica de negocio relacionada con los médicos.
 * Utiliza el repositorio para acceder a los datos de la base de datos.
 * Se encarga de las operaciones CRUD y otras operaciones relacionadas con los médicos.
 */
@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<Medico> listarTodos() {
        return repository.findAll();
    }

    public Optional<Medico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Medico guardar(Medico medico) {
        return repository.save(medico);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}