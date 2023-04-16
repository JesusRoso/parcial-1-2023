package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle getVehicle(Long id);
    List<Vehicle> allVehicles();
    Boolean createVehicle (Long id);
    Boolean updateVehicle(Long id, Vehicle vehicle);
}
