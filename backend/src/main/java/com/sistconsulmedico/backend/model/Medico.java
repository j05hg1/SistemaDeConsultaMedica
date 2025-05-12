package com.sistconsulmedico.backend.model;

import jakarta.persistence.*;

/**
 * Clase que representa la entidad Medico en la base de datos.
 * Esta clase es un modelo que se utiliza para mapear la tabla "medico" en la base de datos.
 * Contiene los atributos y sus respectivos mapeos a las columnas de la tabla.
 * Se utiliza para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
 */
@Entity
@Table(name = "medico")
public class Medico {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico") // ESTE NOMBRE DEBE COINCIDIR con el de la tabla
    private Long idMedico;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String especialidad;

    @Column(name = "numero_licencia", nullable = false, unique = true)
    private String numeroLicencia;

    private String telefono;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    // Getters and Setters
    public Long getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public String getNumeroLicencia() {
        return numeroLicencia;
    }
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
