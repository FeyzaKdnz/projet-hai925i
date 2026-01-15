package com.hai925i.campus.dto.mapper;

import com.hai925i.campus.dto.dto.CampusDTO;
import com.hai925i.campus.model.Campus;
import com.hai925i.campus.model.Universite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CampusMapper {

    @Mapping(source = "universite.nom", target = "nomUniversite")
    CampusDTO toDto(Campus campus);

    @Mapping(source = "nomUniversite", target = "universite", qualifiedByName = "stringToUniversite")
    Campus toEntity(CampusDTO campusDTO);

    @Named("stringToUniversite")
    default Universite stringToUniversite(String nom) {
        if (nom == null) {
            return null;
        }
        Universite universite = new Universite();
        universite.setNom(nom);
        return universite;
    }
}