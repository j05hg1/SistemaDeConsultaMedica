package com.sistconsulmedico.backend.service;

import com.sistconsulmedico.backend.model.Consulta;
import com.sistconsulmedico.backend.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    
    private final ConsultaRepository repository;

    private ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<Consulta> listarTodas() {
        return repository.findAll();
    }

    public Optional<Consulta> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Consulta guardar(Consulta consulta) {

        List<Consulta> consultaTraslapada = repository.findByMedicoAndFecha(
            consulta.getMedico().getIdMedico(), 
            consulta.getFecha(), 
            consulta.getHora(), 
            consulta.getHoraFin());

        // Valida si hay consultas traslapadas
        // Si la lista no está vacía, significa que hay consultas que se traslapan
        if (!consultaTraslapada.isEmpty()) {
            throw new RuntimeException("Ya existe una consulta para la fecha y hora especificadas, escoja otra fecha u hora.");
        }  

        // Valida si ya existe una consulta con la misma fecha y hora
        // if (repository.existsByFechaAndHora(consulta.getFecha(), consulta.getHora())) {
        //     // Aquí puedes agregar lógica adicional si es necesario
        //     throw new RuntimeException("La consulta ya existe para la fecha y hora especificadas.");
        // }
        return repository.save(consulta);
    }

    public Consulta actualizar(Long id, Consulta consulta) {
        Optional<Consulta> consultaExistente = repository.findById(id);
    
        if (consultaExistente.isEmpty()) {
            throw new RuntimeException("La consulta medica no existe.");
        }
    
        // Valida que no se traslape con otras consultas (excepto consigo misma)
        List<Consulta> traslapadas = repository.findByMedicoAndFecha(
            consulta.getMedico().getIdMedico(), 
            consulta.getFecha(), 
            consulta.getHora(), 
            consulta.getHoraFin());
    
        for (Consulta c : traslapadas) {
            if (!c.getIdConsulta().equals(id)) {
                throw new RuntimeException("Ya existe una consulta que se cruza con este horario.");
            }
        }
    
        // Aquí asigna el ID original para evitar que JPA intente crear uno nuevo
        consulta.setIdConsulta(id);
    
        return repository.save(consulta);
    }
    

    public void eliminar(Long id){
        repository.deleteById(id);
    }
}
