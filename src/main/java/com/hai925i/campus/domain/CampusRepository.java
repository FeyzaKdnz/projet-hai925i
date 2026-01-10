package com.hai925i.campus.domain;

import com.hai925i.campus.model.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusRepository extends JpaRepository<Campus, String> {

    Campus findByNomC(String nomC);

    @Query("SELECT COUNT(b) FROM Batiment b WHERE b.campus.nomC = :nomC")
    long countBatimentsByCampusName(@Param("nomC") String nomC);

    @Query("SELECT COUNT(s) FROM Salle s WHERE s.batiment.campus.nomC = :nomC")
    long countSallesByCampusName(@Param("nomC") String nomC);

    @Query("SELECT COUNT(u) FROM Universite u WHERE u.nom = :nomUniversite")
    long countByUniversiteNom(String nomUniversite);

    @Query("SELECT c FROM Campus c WHERE c.universite.nom = :nomUniversite")
    List<Campus> findByUniversiteNom(String nomUniversite);
}