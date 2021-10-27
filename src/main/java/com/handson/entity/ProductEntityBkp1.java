package com.handson.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Entity
@Table(name = "product")
public class ProductEntityBkp1 implements Serializable {

    public ProductEntityBkp1() {
    }

    public ProductEntityBkp1(Integer id, String name, String category, Double price) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private Double price;

    @OneToMany(mappedBy="product")
    private List<CustomerOrderEntityBkp1> customerOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<CustomerOrderEntityBkp1> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrderEntityBkp1> customerOrders) {
        this.customerOrders = customerOrders;
    }

/*@Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }*/
}
