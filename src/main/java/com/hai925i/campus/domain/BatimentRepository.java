package com.hai925i.campus.domain;

import com.hai925i.campus.model.Batiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatimentRepository extends JpaRepository<Batiment, String> {

    List<Batiment> findByCampusNomC(String nomC);
    List<Batiment> findByCampusUniversiteNom(String nomUniversite);

}