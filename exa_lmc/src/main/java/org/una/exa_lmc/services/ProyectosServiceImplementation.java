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
import org.una.exa_lmc.dto.ProyectosDTO;
import org.una.exa_lmc.entities.Proyectos;
import org.una.exa_lmc.repositories.IProyectosRepository;
import org.una.exa_lmc.utils.Convertir;
import org.una.exa_lmc.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class ProyectosServiceImplementation implements IProyectosService {

    @Autowired
    private IProyectosRepository proyectosRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProyectosDTO>> findAll() {
        return (Optional<List<ProyectosDTO>>) Convertir.findList(Optional.ofNullable(proyectosRepository.findAll()), ProyectosDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProyectosDTO> findById(Long id) {
        return (Optional<ProyectosDTO>) Convertir.oneToDto(proyectosRepository.findById(id), ProyectosDTO.class);
    }

    @Override
    @Transactional
    public ProyectosDTO create(ProyectosDTO proyectosDTO) {
        Proyectos proyectos = MapperUtils.EntityFromDto(proyectosDTO, Proyectos.class);
        proyectos = proyectosRepository.save(proyectos);
        return MapperUtils.DtoFromEntity(proyectos, ProyectosDTO.class);
    }

    @Override
    @Transactional
    public Optional<ProyectosDTO> update(ProyectosDTO proyectosDTO, Long id) {
        if (proyectosRepository.findById(id).isPresent()) {
            Proyectos proyectos = MapperUtils.EntityFromDto(proyectosDTO, Proyectos.class);
            proyectos = proyectosRepository.save(proyectos);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(proyectos, ProyectosDTO.class));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        proyectosRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        proyectosRepository.deleteAll();
    }
}
