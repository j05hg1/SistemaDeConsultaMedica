package com.sistconsulmedico.backend.service;

import com.sistconsulmedico.backend.model.Usuario;
import com.sistconsulmedico.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Usuario guardar(Usuario usuario){
        return repository.save(usuario);
    }
    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
