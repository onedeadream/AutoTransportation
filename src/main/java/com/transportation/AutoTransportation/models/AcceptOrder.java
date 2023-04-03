package com.transportation.AutoTransportation.models;

import javax.persistence.*;

@Entity
@Table(name = "requestOrder")
public class AcceptOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long orderId;
    private String driver;
    private String model;
    private String carNumber;
    private int price;
    private Long userId;
    public AcceptOrder(){}

    public AcceptOrder(Long id, Long orderId, String driver, String model, String number, String carNumber, int price, Long userId){
        this.id = id;
        this.orderId = orderId;
        this.driver = driver;
        this.model = model;
        this.carNumber = carNumber;
        this.price = price;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
