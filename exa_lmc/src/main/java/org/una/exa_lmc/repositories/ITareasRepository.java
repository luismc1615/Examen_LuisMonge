/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.exa_lmc.entities.Tareas;

/**
 *
 * @author Luis
 */
public interface ITareasRepository extends JpaRepository<Tareas, Long>{
    
}
