/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author Luis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TareasDTO {

    private Long id;
    private Date fecha_inicio;
    private Date fecha_finalizacion;
    private double importancia;
    private double urgencia;
    private double prioridad;
    private double porcentaje_avance;
    private ProyectosDTO proyectos;
}
