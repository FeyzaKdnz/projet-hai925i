package com.hai925i.campus.domain;

import com.hai925i.campus.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, String> {

    List<Salle> findByTypeS(String typeS);
    List<Salle> findByBatimentCodeB(String codeB);
    List<Salle> findByBatimentCampusNomC(String nomCampus);
    List<Salle> findByBatimentCampusUniversiteNom(String nomUniversite);

    @Query("SELECT s.batiment.codeB, COUNT(s) FROM Salle s GROUP BY s.batiment.codeB")
    List<Object[]> countSallesByBatiment();

    @Query("SELECT s.typeS, COUNT(s) FROM Salle s GROUP BY s.typeS")
    List<Object[]> countSallesByTypeS();

    @Query("SELECT s.typeS, COUNT(s) FROM Salle s WHERE s.batiment.campus.universite.nom = :nomUni GROUP BY s.typeS")
    List<Object[]> countByTypeForUniversite(@Param("nomUni") String nomUni);

    @Query("SELECT s.typeS, COUNT(s) FROM Salle s WHERE s.batiment.campus.nomC = :nomCampus GROUP BY s.typeS")
    List<Object[]> countByTypeForCampus(@Param("nomCampus") String nomCampus);

    @Query("SELECT s FROM Salle s WHERE " +
            "s.batiment.campus.universite.nom = :nomUni AND " +
            "(:keyword IS NULL OR s.numSalle LIKE %:keyword%) AND " +
            "(:etage IS NULL OR s.etage = :etage) AND " +
            "(:acces IS NULL OR s.accessibilite = :acces) AND " +
            "(:batiment IS NULL OR s.batiment.codeB = :batiment) AND " +
            "(:campus IS NULL OR s.batiment.campus.nomC = :campus) AND " +
            "(:capMin IS NULL OR s.capacite >= :capMin)")
    List<Salle> searchSalles(@Param("keyword") String keyword,
                             @Param("etage") String etage,
                             @Param("acces") String acces,
                             @Param("batiment") String batimentCode,
                             @Param("campus") String campus,
                             @Param("nomUni") String nomUni,
                             @Param("capMin") Integer capMin);
}