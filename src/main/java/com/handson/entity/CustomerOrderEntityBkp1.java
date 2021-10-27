package com.handson.entity;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
public class CustomerOrderEntityBkp1 {

    @EmbeddedId
    private OrderProductEntity id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderEntityBkp1 order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntityBkp1 product;

    @Column(name = "status")
    private String status;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    public OrderProductEntity getId() {
        return id;
    }

    public void setId(OrderProductEntity id) {
        this.id = id;
    }

    public OrderEntityBkp1 getOrder() {
        return order;
    }

    public void setOrder(OrderEntityBkp1 order) {
        this.order = order;
    }

    public ProductEntityBkp1 getProduct() {
        return product;
    }

    public void setProduct(ProductEntityBkp1 product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

/*@Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }*/
}
