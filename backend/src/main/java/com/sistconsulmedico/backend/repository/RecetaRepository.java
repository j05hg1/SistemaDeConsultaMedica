package com.sistconsulmedico.backend.repository;

import com.sistconsulmedico.backend.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    // Aquí se puede agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar recetas por paciente o médico, etc.
    
    // Filtros
    // List<Receta> findByPacienteId(Long pacienteId);
    // List<Receta> findByMedicoId(Long medicoId);
    // List<Receta> findByFecha(Date fecha);
    // List<Receta> findByFechaBetween(Date startDate, Date endDate);
    // List<Receta> findByConsultaId(Long consultaId);
}
