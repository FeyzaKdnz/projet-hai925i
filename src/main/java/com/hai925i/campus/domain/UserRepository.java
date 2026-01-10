package com.hai925i.campus.domain;

import com.hai925i.campus.model.Role;
import com.hai925i.campus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    List<User> findByUniversiteNom(String nomUniversite);
    List<User> findByUniversiteNomAndRole(String nomUniversite, Role role);

    @Query("SELECT u FROM User u WHERE " +
            "u.universite.nom = :nomUni AND " +
            "(:role IS NULL OR u.role = :role) AND " +
            "(:campus IS NULL OR u.campus.nomC = :campus)")
    List<User> searchUsers(@Param("nomUni") String nomUni,
                           @Param("role") Role role,
                           @Param("campus") String campusNom);
}