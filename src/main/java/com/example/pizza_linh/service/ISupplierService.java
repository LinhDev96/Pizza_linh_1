package com.example.pizza_linh.service;

import com.example.pizza_linh.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface ISupplierService {
    Supplier insert(Supplier supplier);

    Optional<Supplier> findById(Integer id);

    List<Supplier> findAll();
}
