package com.parcial_procesos.vehiculos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VehicleList {
    private List<Vehicle> cars;
    public List<Vehicle> getCars(){return cars;}

}
