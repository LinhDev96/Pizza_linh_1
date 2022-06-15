package com.example.pizza_linh.repository;

import com.example.pizza_linh.model.RawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RawMaterialRepository extends JpaRepository<RawMaterial,Integer> {
    Optional<RawMaterial> findByName(String name);
}
