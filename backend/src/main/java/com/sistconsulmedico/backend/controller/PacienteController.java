package com.sistconsulmedico.backend.controller;

import com.sistconsulmedico.backend.model.Paciente;
import com.sistconsulmedico.backend.service.PacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar las operaciones relacionadas con los pacientes.
 * Proporciona endpoints para crear, leer, actualizar y eliminar pacientes.
 * Utiliza el servicio de PacienteService para realizar las operaciones necesarias.
 */
@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    /**
     * Se utilizan las anotaciones @GetMapping, @PostMapping, @PutMapping y @DeleteMapping para manejar las solicitudes HTTP.
     * Estas anotaciones indican el tipo de solicitud HTTP que se espera (GET, POST, PUT, DELETE) y la URL a la que se asigna el método.
     */

    /**
     * Método (Endpoint) para listar todos los pacientes.
     * Se utiliza @GetMapping para manejar las solicitudes GET a la URL /api/pacientes.
     * El método listar() devuelve una lista de todos los pacientes en la base de datos.
     * Se utiliza el servicio PacienteService para obtener la lista de pacientes.
     * El método listarTodos() devuelve una lista de objetos Paciente.
     */
    @GetMapping
    public List<Paciente> listar() {
        return service.listarTodos();
    }

    /**
    * Método (Endpoint) para buscar un paciente por su ID.
    * Se utiliza @PathVariable para extraer el ID de la URL.
    * El ID se pasa al servicio para buscar el paciente correspondiente.
    * Si se encuentra el paciente, se devuelve como respuesta con un código 200 OK.
    * Si no se encuentra, se devuelve un código 404 Not Found.
    * El método buscarPorId devuelve un Optional<Paciente>, que puede contener el paciente o estar vacío.
    * Se utiliza el método map de Optional para transformar el valor si está presente.
    * Si el paciente no está presente, se devuelve un ResponseEntity con un código 404 Not Found.
    * El método ResponseEntity es una clase que representa la respuesta HTTP, incluyendo el cuerpo y los encabezados.
    * Se utiliza para construir respuestas HTTP de manera más flexible.
    * En este caso, se utiliza para devolver el paciente encontrado o un código 404 si no se encuentra.
    * El método ResponseEntity.ok() devuelve un ResponseEntity con un código 200 OK y el cuerpo del paciente.
    * El método ResponseEntity.notFound().build() devuelve un ResponseEntity con un código 404 Not Found y sin cuerpo.
    * El método ResponseEntity es parte de la biblioteca Spring y se utiliza para construir respuestas HTTP de manera más flexible.
    */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Método (Endpoint) para crear un nuevo paciente.
     * Se utiliza @RequestBody para extraer el cuerpo de la solicitud y convertirlo en un objeto Paciente.
     * El objeto Paciente se guarda en la base de datos a través del servicio.
     * Se devuelve el paciente creado como respuesta.
     */    
    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return service.guardar(paciente);
    }

    /**
     * Método (Endpoint) para actualizar un paciente existente.
     * Se utiliza @PathVariable para extraer el ID de la URL y @RequestBody para extraer el cuerpo de la solicitud.
     * Se busca el paciente por su ID y, si se encuentra, se actualiza con los nuevos datos, y devuelve 200 OK. 
     * Si no existe, devuelve 404 Not Found
     */
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        return service.buscarPorId(id)
                .map(p -> {
                    paciente.setIdPaciente(id);
                    return ResponseEntity.ok(service.guardar(paciente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Método (Endpoint) para eliminar un paciente por su ID.
     * Se utiliza @PathVariable para extraer el ID de la URL.
     * Se busca el paciente por su ID y, si se encuentra, se elimina de la base de datos.
     * Se devuelve un código 204 No Content si se elimina correctamente.
     * Si no se encuentra el paciente, se devuelve un código 404 Not Found.
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
