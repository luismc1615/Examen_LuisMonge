/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.services;

import java.util.List;
import java.util.Optional;
import org.una.exa_lmc.dto.TareasDTO;

/**
 *
 * @author Luis
 */
public interface ITareasService {

    public Optional<List<TareasDTO>> findAll();

    public Optional<TareasDTO> findById(Long id);

    public TareasDTO create(TareasDTO tareasDTO);

    public Optional<TareasDTO> update(TareasDTO tareasDTO, Long id);

    public void delete(Long id);

    public void deleteAll();
}
