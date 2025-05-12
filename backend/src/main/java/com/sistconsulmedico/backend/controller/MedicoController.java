package com.sistconsulmedico.backend.controller;

import com.sistconsulmedico.backend.model.Medico;
import com.sistconsulmedico.backend.service.MedicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con los médicos.
 * Proporciona endpoints para crear, leer, actualizar y eliminar médicos.
 * Utiliza el servicio de MedicoService para realizar las operaciones necesarias.
 */
@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    // Aquí se puede implementar los métodos del controlador para manejar las solicitudes HTTP
    // y utilizar el servicio de MedicoService para interactuar con la base de datos.
    
    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }
    /**
     * Se utilizan las anotaciones @GetMapping, @PostMapping, @PutMapping y @DeleteMapping para manejar las solicitudes HTTP.
     * Estas anotaciones indican el tipo de solicitud HTTP que se espera (GET, POST, PUT, DELETE) y la URL a la que se asigna el método.
     */
    @GetMapping
    public List<Medico> listar(){
        return service.listarTodos();
    }
    /**
     * Método (Endpoint) para buscar un médico por su ID.
     * Se utiliza @PathVariable para extraer el ID de la URL.
     * El ID se pasa al servicio para buscar el médico correspondiente.
     * Si se encuentra el médico, se devuelve como respuesta con un código 200 OK.
     * Si no se encuentra, se devuelve un código 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    /**
     * Método (Endpoint) para crear un nuevo médico.
     * Se utiliza @RequestBody para extraer el cuerpo de la solicitud y convertirlo en un objeto Medico.
     * El médico se guarda en la base de datos utilizando el servicio.
     * Se devuelve el médico creado como respuesta con un código 201 Created.
     * El método guardar() del servicio se encarga de guardar el médico en la base de datos.
     */
    @PostMapping
    public Medico crear(@RequestBody Medico medico){
        return service.guardar(medico);
    }
    /**
     * Método (Endpoint) para actualizar un médico existente.
     * Se utiliza @PathVariable para extraer el ID de la URL y @RequestBody para extraer el cuerpo de la solicitud.
     * El ID se utiliza para buscar el médico existente en la base de datos.
     * Si se encuentra el médico, se actualiza con los nuevos datos y se guarda en la base de datos.
     * Se devuelve el médico actualizado como respuesta con un código 200 OK.
     * Si no se encuentra el médico, se devuelve un código 404 Not Found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Long id, @RequestBody Medico medico){
        return service.buscarPorId(id)
                .map(medicoExistente -> {
                    medico.setIdMedico(id);
                    return ResponseEntity.ok(service.guardar(medico));
                })
                .orElse(ResponseEntity.notFound().build());
    }
    /**
     * Método (Endpoint) para eliminar un médico por su ID.
     * Se utiliza @PathVariable para extraer el ID de la URL.
     * El ID se pasa al servicio para eliminar el médico correspondiente.
     * Si se encuentra el médico, se elimina y se devuelve un código 204 No Content.
     * Si no se encuentra, se devuelve un código 404 Not Found.
     * El método eliminar() del servicio se encarga de eliminar el médico de la base de datos.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }    
}
