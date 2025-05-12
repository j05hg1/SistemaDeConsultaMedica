package com.sistconsulmedico.backend.repository;

import com.sistconsulmedico.backend.model.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Aquí se puede agregar métodos personalizados si es necesario
    // Por ejemplo, para buscar consultas por paciente o médico, etc.
    
    // Filtros
    // List<Consulta> findByPacienteId(Long pacienteId);
    // List<Consulta> findByMedicoId(Long medicoId);
    // List<Consulta> findByFecha(Date fecha);
    // List<Consulta> findByFechaBetween(Date startDate, Date endDate);
    boolean existsByFechaAndHora(LocalDate fechaHora, LocalTime hora);
    
    @Query("SELECT c FROM Consulta c WHERE c.medico.idMedico = :idMedico and c.fecha = :fecha AND (:hora < c.horaFin and :horaFin > c.hora)")
    List<Consulta> findByMedicoAndFecha(@Param("idMedico")Long idMedico, @Param("fecha")LocalDate fecha, @Param("hora")LocalTime hora, @Param("horaFin")LocalTime horaFin);
}
