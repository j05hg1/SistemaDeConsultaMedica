package com.sistconsulmedico.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta") // ESTE NOMBRE DEBE COINCIDIR con el de la tabla
    private Long idReceta;

    @Column(nullable = false)
    private String medicamento;

    @Column(length = 50)
    private String dosis;

    @Column(columnDefinition = "TEXT")
    private String instrucciones;

    // Relaciones
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_consulta", referencedColumnName = "id_consulta", nullable = false)
    private Consulta consulta;

    // Getters and Setters

    public Long getIdReceta() {
        return idReceta;
    }
    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }
    public String getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
    public String getDosis() {
        return dosis;
    }
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    public String getInstrucciones() {
        return instrucciones;
    }
    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }
    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
