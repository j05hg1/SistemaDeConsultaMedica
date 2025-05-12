package com.sistconsulmedico.backend.repository;

import com.sistconsulmedico.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsername(String username);
    // Optional<Usuario> findByUsernameAndPassword(String username, String password);
    boolean existsByUsername(String username);
}
