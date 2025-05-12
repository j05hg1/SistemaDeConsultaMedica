package com.sistconsulmedico.backend.controller;

import com.sistconsulmedico.backend.model.Consulta;
import com.sistconsulmedico.backend.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Consulta> listar() {
        return service.listarTodas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Consulta> crear(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(service.guardar(consulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> actualizar(@PathVariable Long id, @RequestBody Consulta consulta) {
        
        try {
            Consulta actualizada = service.actualizar(id, consulta);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
        
        // return service.buscarPorId(id)
        //         .map(consultaExistente -> {
        //             consulta.setIdConsulta(id);
        //             return ResponseEntity.ok(service.guardar(consulta));
        //         })
        //         .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
