package com.example.pizza_linh.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer supplierId;

    private String name;

    private String address;

    private String email;

    @OneToMany(targetEntity = RawMaterial.class, mappedBy = "supplier",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<RawMaterial> rawMaterials = new ArrayList<>();

    public Supplier(Integer supplierId, String name, String address, String email, List<RawMaterial> rawMaterials) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.rawMaterials = rawMaterials;
    }

    public Supplier() {
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RawMaterial> getRawMaterials() {
        return rawMaterials;
    }

    public void setRawMaterials(List<RawMaterial> rawMaterials) {
        this.rawMaterials = rawMaterials;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", rawMaterials=" + rawMaterials +
                '}';
    }
}
