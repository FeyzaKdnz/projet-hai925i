package com.hai925i.campus.dto.mapper;

import com.hai925i.campus.dto.dto.CampusDTO;
import com.hai925i.campus.model.Campus;
import com.hai925i.campus.model.Universite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring") // Permet d'injecter ce mapper avec @Autowired
public interface CampusMapper {

    // Conversion Entity -> DTO
    // On dit à MapStruct : "Prends le nom de l'université dans l'objet Universite et mets-le dans le champ nomUniversite du DTO"
    @Mapping(source = "universite.nom", target = "nomUniversite")
    CampusDTO toDto(Campus campus);

    // Conversion DTO -> Entity
    // C'est un peu plus complexe : on a juste un String (nomUniversite) et on doit créer un objet Universite
    @Mapping(source = "nomUniversite", target = "universite", qualifiedByName = "stringToUniversite")
    Campus toEntity(CampusDTO campusDTO);

    // Méthode utilitaire pour convertir le String nomUniversite en objet Universite (avec juste l'ID)
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