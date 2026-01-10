package com.hai925i.campus.domain;

import com.hai925i.campus.model.Composante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposanteRepository extends JpaRepository<Composante, String> {
}