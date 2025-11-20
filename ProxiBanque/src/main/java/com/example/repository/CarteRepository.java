package com.example.repository;

import com.example.entity.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteRepository extends JpaRepository<Carte, Long> {}
