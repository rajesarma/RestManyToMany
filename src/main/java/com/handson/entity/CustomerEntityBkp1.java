package com.handson.entity;

import javax.persistence.*;
import java.util.List;

//@Entity
@Table(name = "customer")
public class CustomerEntityBkp1 {
    public CustomerEntityBkp1() {

    }

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tier")
    private Integer tier;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntityBkp1> orders;

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

    public List<OrderEntityBkp1> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntityBkp1> orders) {
        this.orders = orders;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    /*@Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                ", orders=" + orders +
                '}';
    }*/
}
