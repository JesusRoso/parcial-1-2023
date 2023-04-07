package com.parcial_procesos.vehiculos.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String car;
    @Column(name="car_model")
    private String carModel;
    @Column(name="car_color")
    private String carColor;
    @Column(name="car_model_year")
    private Integer carModelYear;
    @Column(name="car_vin")
    private String carVin;
    private String price;
    private Boolean availability;

}
