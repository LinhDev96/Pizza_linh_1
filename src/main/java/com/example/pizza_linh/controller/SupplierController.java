package com.example.pizza_linh.controller;

import com.example.pizza_linh.model.ResponseObject;
import com.example.pizza_linh.model.Supplier;
import com.example.pizza_linh.model.WrapperSupplierMaterial;
import com.example.pizza_linh.service.IRawMaterialService;
import com.example.pizza_linh.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/Supplier")
public class SupplierController {

    @Autowired
    private ISupplierService iSupplierService;

    @Autowired
    private IRawMaterialService iRawMaterialService;

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody WrapperSupplierMaterial supplier){
        Optional<Supplier> optionalSupplier = Optional.ofNullable(iSupplierService.insert(supplier.getSupplier()));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","successfully",optionalSupplier)

        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getSupplier(@PathVariable Integer id){
        Optional<Supplier> supplier = iSupplierService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","query Supplier successfully",supplier)
        );
    }

    @GetMapping("/findAll")
    public  ResponseEntity<ResponseObject> findAllSupplier(){
        List<Supplier> optionalSupplier = iSupplierService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "successfully", optionalSupplier)
        );
    }


}
