package com.hai925i.campus.dto.mapper;

import com.hai925i.campus.dto.dto.SalleDTO;
import com.hai925i.campus.model.Batiment;
import com.hai925i.campus.model.Salle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SalleMapper {

    // Entité (Salle) -> DTO (SalleDTO)
    @Mapping(source = "numSalle", target = "numS")
    @Mapping(source = "accessibilite", target = "acces") // Mapping explicite
    @Mapping(source = "batiment.codeB", target = "codeBatiment")
    SalleDTO toDto(Salle salle);

    // DTO (SalleDTO) -> Entité (Salle)
    @Mapping(source = "numS", target = "numSalle")
    @Mapping(source = "acces", target = "accessibilite") // Mapping explicite
    @Mapping(source = "codeBatiment", target = "batiment", qualifiedByName = "stringToBatiment")
    Salle toEntity(SalleDTO salleDTO);

    @Named("stringToBatiment")
    default Batiment stringToBatiment(String code) {
        if (code == null) return null;
        Batiment batiment = new Batiment();
        batiment.setCodeB(code);
        return batiment;
    }
}