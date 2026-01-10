package com.hai925i.campus.dto.mapper;

import com.hai925i.campus.dto.dto.BatimentDTO;
import com.hai925i.campus.model.Batiment;
import com.hai925i.campus.model.Campus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BatimentMapper {

    @Mapping(source = "campus.nomC", target = "nomCampus")
    BatimentDTO toDto(Batiment batiment);

    @Mapping(source = "nomCampus", target = "campus", qualifiedByName = "stringToCampus")
    Batiment toEntity(BatimentDTO batimentDTO);

    @Named("stringToCampus")
    default Campus stringToCampus(String nom) {
        if (nom == null) return null;
        Campus campus = new Campus();
        campus.setNomC(nom);
        return campus;
    }
}