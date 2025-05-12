package com.sistconsulmedico.backend.controller;

import com.sistconsulmedico.backend.model.Receta;
import com.sistconsulmedico.backend.service.RecetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {
    
    private final RecetaService service;

    public RecetaController(RecetaService service){
        this.service = service;
    }

    @GetMapping
    public List<Receta> listar(){
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> buscar(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Receta> crear(@RequestBody Receta receta){
        return ResponseEntity.ok(service.guardar(receta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizar(@PathVariable Long id, @RequestBody Receta receta){
        return service.buscarPorId(id)
                .map(recetaExistente -> {
                    receta.setIdReceta(id);
                    return ResponseEntity.ok(service.guardar(receta));
                })
                .orElse(ResponseEntity.notFound().build());
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
