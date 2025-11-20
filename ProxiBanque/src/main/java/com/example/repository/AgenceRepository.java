package com.example.repository;

import com.example.entity.Agence;
import com.example.entity.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence,Long> {
}
