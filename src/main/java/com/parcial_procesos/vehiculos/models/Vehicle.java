package com.parcial_procesos.vehiculos.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Vehicle {
    @Id
    private Long id;
    private String car;
    @Column(name="car_model")
    private String car_model;
    @Column(name="car_color")
    private String car_color;
    @Column(name="car_model_year")
    private Integer car_model_year;
    @Column(name="car_vin")
    private String car_vin;
    private String price;
    private Boolean availability;
    @ManyToOne
    private User user;
}
