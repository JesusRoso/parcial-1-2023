package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleServiceImp implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public Boolean createVehicle(Vehicle vehicle) {
        try{
            vehicleRepository.save(vehicle);
            return true;
        }
        catch (Exception e){
            return  false;
        }
    }

    @Override
    public List<Vehicle> allVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Boolean updateVehicle(Long id, Vehicle vehicle) {
        try{
            Vehicle vehicleBD = vehicleRepository.findById(id).get();
            vehicleBD.setCar(vehicle.getCar());
            vehicleBD.setCarModel(vehicle.getCarModel());
            vehicleBD.setCarColor(vehicle.getCarColor());
            vehicleBD.setCarModelYear(vehicle.getCarModelYear());
            vehicleBD.setCarVin(vehicle.getCarVin());
            vehicleBD.setPrice(vehicle.getPrice());
            vehicleBD.setAvailability(vehicle.getAvailability());
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
