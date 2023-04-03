package com.transportation.AutoTransportation.models;

import javax.persistence.*;

@Entity
@Table(name = "orderAll")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstPoint;
    private String lastPoint;
    private int kilometers;
    private String number;
    private String tariff;
    private int payment;
    private Long userId;



    public Order(){
    }

    public Order(Long id, String firstPoint, String lastPoint, int kilometers, String number, String tariff, Long userId, int payment){
        this.id = id;
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.kilometers = kilometers;
        this.number = number;
        this.tariff = tariff;
        this.userId = userId;
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(String firstPoint) {
        this.firstPoint = firstPoint;
    }

    public String getLastPoint() {
        return lastPoint;
    }

    public void setLastPoint(String lastPoint) {
        this.lastPoint = lastPoint;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getPayment() {
        return payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }
}
