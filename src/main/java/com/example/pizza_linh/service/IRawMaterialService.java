package com.example.pizza_linh.service;

import com.example.pizza_linh.model.RawMaterial;

import java.util.List;
import java.util.Optional;

public interface IRawMaterialService {
    List<RawMaterial> findAll();
    Optional<RawMaterial> findById(Integer id);
    void insert(RawMaterial rawMaterial);
    void update(RawMaterial rawMaterial);
    RawMaterial save(RawMaterial rawMaterial);
    Optional<RawMaterial> findByName(String name);
    void deleteById(Integer id);
}
