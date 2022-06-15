package com.example.pizza_linh.service.serviceimpl;

import com.example.pizza_linh.model.Supplier;
import com.example.pizza_linh.repository.SupplierRepository;
import com.example.pizza_linh.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements ISupplierService {
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier insert(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> findById(Integer id) {
        return supplierRepository.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }
}
