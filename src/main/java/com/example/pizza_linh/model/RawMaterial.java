package com.example.pizza_linh.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "raw_material")//dat ten cho bang
public class RawMaterial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_code")
    private Integer productCode;

    @Column
    private Long barcode;

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)//khong lay nhung thu lien quan
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column
    private Long price;

    @Column
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private FBStatus fbStatus;


    public RawMaterial(Integer productCode, Long barcode, String name, Supplier supplier, Long price, Integer quantity, FBStatus fbStatus) {
        this.productCode = productCode;
        this.barcode = barcode;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
        this.quantity = quantity;
        this.fbStatus = fbStatus;
    }

    public RawMaterial() {

    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "productCode=" + productCode +
                ", barcode=" + barcode +
                ", name='" + name + '\'' +
                ", supplier=" + supplier +
                ", price=" + price +
                ", quantity=" + quantity +
                ", fbStatus=" + fbStatus +
                '}';
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public FBStatus getFbStatus() {
        return fbStatus;
    }

    public void setFbStatus(FBStatus fbStatus) {
        this.fbStatus = fbStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawMaterial that = (RawMaterial) o;
        return Objects.equals(barcode, that.barcode) && Objects.equals(name, that.name) && Objects.equals(supplier, that.supplier) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity) && fbStatus == that.fbStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, barcode, name, supplier, price, quantity, fbStatus);
    }
}
