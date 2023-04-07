package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle getVehicle(Long id);
    Boolean createVehicle(Vehicle vehicle);
    List<Vehicle> allVehicles();
    Boolean updateVehicle(Long id, Vehicle vehicle);
}
