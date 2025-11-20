package com.example.repository;

import com.example.entity.Gerant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerantRepository extends JpaRepository<Gerant,Long> {
}
