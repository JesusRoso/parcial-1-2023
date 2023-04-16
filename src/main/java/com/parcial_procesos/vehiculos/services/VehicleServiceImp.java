package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ApiVehicleServiceImp apiVehicleServiceImp;
    @Override
    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).get();
    }

    @Override
    public List<Vehicle> allVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Boolean createVehicle(Long id){
        try{
            return apiVehicleServiceImp.saveVehicle(id);
        }
        catch (Exception e){
            return false;
        }
    }
    @Override
    public Boolean updateVehicle(Long id, Vehicle vehicle) {
        try{
            Vehicle vehicleBD = vehicleRepository.findById(id).get();
            vehicleBD.setCar(vehicle.getCar());
            vehicleBD.setCar_model(vehicle.getCar_model());
            vehicleBD.setCar_color(vehicle.getCar_color());
            vehicleBD.setCar_model_year(vehicle.getCar_model_year());
            vehicleBD.setCar_vin(vehicle.getCar_vin());
            vehicleBD.setPrice(vehicle.getPrice());
            vehicleBD.setAvailability(vehicle.getAvailability());
            vehicleRepository.save(vehicleBD);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
