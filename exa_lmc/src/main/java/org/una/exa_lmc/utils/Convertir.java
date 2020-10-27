/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.exa_lmc.utils;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Luis
 */
public class Convertir {
    
    public static Optional findList(List list,Class c) {
        if (list != null) {
            List<Object> listObj = MapperUtils.DtoListFromEntityList(list, c);
            return Optional.ofNullable(listObj);
        } else {
            return Optional.empty();
        }
    }

    public static Optional findList(Optional<List> list,Class c) {
        if (list.isPresent()) {
            return findList(list.get(),c);
        } else {
            return Optional.empty();
        }
    }

    public static Optional oneToDto(Optional one,Class c) {
        if (one.isPresent()) {
            Object op = MapperUtils.DtoFromEntity(one.get(),c);
            return Optional.ofNullable(op);
        } else {
            return Optional.empty();
        }
    }
}
