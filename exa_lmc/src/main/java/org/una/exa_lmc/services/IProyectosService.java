/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.services;

import java.util.List;
import java.util.Optional;
import org.una.exa_lmc.dto.ProyectosDTO;

/**
 *
 * @author Luis
 */
public interface IProyectosService {

    public Optional<List<ProyectosDTO>> findAll();

    public Optional<ProyectosDTO> findById(Long id);

    public ProyectosDTO create(ProyectosDTO proyectosDTO);

    public Optional<ProyectosDTO> update(ProyectosDTO proyectosDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
