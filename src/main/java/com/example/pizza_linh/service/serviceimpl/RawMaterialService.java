package com.example.pizza_linh.service.serviceimpl;

import com.example.pizza_linh.model.RawMaterial;
import com.example.pizza_linh.repository.RawMaterialRepository;
import com.example.pizza_linh.service.IRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialService implements IRawMaterialService {
    private RawMaterialRepository rawMaterialRepository;

    @Autowired
    public RawMaterialService(RawMaterialRepository rawMaterialRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @Override
    public List<RawMaterial> findAll() {
        return rawMaterialRepository.findAll();
    }

    @Override
    public Optional<RawMaterial> findById(Integer id){
        return rawMaterialRepository.findById(id);
    }

    @Override
    public void insert(RawMaterial rawMaterial) {
        rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public void update(RawMaterial rawMaterial) {
        rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public RawMaterial save(RawMaterial rawMaterial) {
        return rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public Optional<RawMaterial> findByName(String name) {
        return rawMaterialRepository.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        rawMaterialRepository.deleteById(id);
    }

}
