/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.exa_lmc.dto.TareasDTO;
import org.una.exa_lmc.entities.Tareas;
import org.una.exa_lmc.repositories.ITareasRepository;
import org.una.exa_lmc.utils.Convertir;
import org.una.exa_lmc.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class TareasServiceImplementation implements ITareasService{

    @Autowired
    private ITareasRepository tareasRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TareasDTO>> findAll() {
        return (Optional<List<TareasDTO>>) Convertir.findList(Optional.ofNullable(tareasRepository.findAll()), TareasDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TareasDTO> findById(Long id) {
        return (Optional<TareasDTO>) Convertir.oneToDto(tareasRepository.findById(id), TareasDTO.class);
    }

    @Override
    @Transactional
    public TareasDTO create(TareasDTO tareasDTO) {
        Tareas tareas = MapperUtils.EntityFromDto(tareasDTO, Tareas.class);
        tareas = tareasRepository.save(tareas);
        return MapperUtils.DtoFromEntity(tareas, TareasDTO.class);
    }

    @Override
    @Transactional
    public Optional<TareasDTO> update(TareasDTO tareasDTO, Long id) {
        if (tareasRepository.findById(id).isPresent()) {
            Tareas tareas = MapperUtils.EntityFromDto(tareasDTO, Tareas.class);
            tareas = tareasRepository.save(tareas);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(tareas, TareasDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tareasRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tareasRepository.deleteAll();
    }
}
