package com.sistconsulmedico.backend.repository;

import com.sistconsulmedico.backend.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que hereda de JpaRepository
 * Es la capa que se comunica directamente con la base de datos (PostgreSQL), 
 * pero no se usa directamente desde el controlador. 
 * Se accede a través del servicio.
 * Se encarga de recibir las peticiones del controlador y ejecutar lo necesario usando el repositorio.
 * Abstrae la lógica de acceso a datos para que el controlador no lo haga directamente.
 */
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre o especialidad
    boolean existsByNumeroLicencia(String numeroLicencia); // Verifica si el número de licencia ya existe
}