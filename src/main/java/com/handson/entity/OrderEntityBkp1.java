package com.handson.entity;

import javax.persistence.*;
import java.util.List;

//@Entity
public class OrderEntityBkp1 {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntityBkp1 customer;

    @OneToMany(mappedBy="order")
    private List<CustomerOrderEntityBkp1> customerOrders;

}
