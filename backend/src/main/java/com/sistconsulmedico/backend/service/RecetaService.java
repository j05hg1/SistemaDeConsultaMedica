package com.sistconsulmedico.backend.service;

import com.sistconsulmedico.backend.model.Receta;
import com.sistconsulmedico.backend.repository.RecetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {
    
    private final RecetaRepository repository;

    public RecetaService(RecetaRepository repository) {
        this.repository = repository;
    }
    public List<Receta> listarTodas() {
        return repository.findAll();
    }
    public Optional<Receta> buscarPorId(Long id) {
        return repository.findById(id);
    }
    public Receta guardar(Receta receta) {
        return repository.save(receta);
    }
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
