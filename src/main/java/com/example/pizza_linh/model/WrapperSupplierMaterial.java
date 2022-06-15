package com.example.pizza_linh.model;

import jdk.jfr.DataAmount;

import javax.persistence.Entity;
import javax.persistence.Id;

@DataAmount
public class WrapperSupplierMaterial {

    private Supplier supplier;

    public WrapperSupplierMaterial(Supplier supplier) {
        this.supplier = supplier;
    }

    public WrapperSupplierMaterial() {

    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "WrapperSupplierMaterial{" +
                "supplier=" + supplier +
                '}';
    }
}
