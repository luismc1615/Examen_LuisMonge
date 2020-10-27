/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "exa_lmc_tareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Tareas implements Serializable {
    
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyectos proyectos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "fecha_inicio")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;

    @Column(name = "fecha_finalizacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fecha_finalizacion;

    @Column(name = "importancia")
    private double importancia;

    @Column(name = "urgencia")
    private double urgencia;

    @Column(name = "prioridad")
    private double prioridad;

    @Column(name = "porcentaje_avance")
    private double porcentaje_avance;

    @PrePersist
    public void prePersist() {

        fecha_inicio = new Date();
        fecha_finalizacion = new Date();
    }
}
