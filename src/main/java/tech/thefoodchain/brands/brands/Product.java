package tech.thefoodchain.brands.brands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="upc14")
    private long upc14;
    @Column(name="upc12")
    private long upc12;
    @Column(name="brand")
    private String brand;
    @Column(name="name")
    private String name;

    public Product(){

    }

    public Product(int id, long upc14, long upc12, String brand, String name){
        this.id = id;
        this.upc14 = upc14;
        this.upc12 = upc12;
        this.brand = brand;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public long getUpc14() {
        return upc14;
    }

    public long getUpc12() {
        return upc12;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setUpc14(long upc14){
        this.upc14 = upc14;
    }

    public void setUpc12(long upc12){
        this.upc12 = upc12;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setName(String name){
        this.name = name;
    }
}
