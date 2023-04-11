package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiVehicleServiceImp implements ApiVehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Boolean saveVehicle() {
        String urlApi = "https://myfakeapi.com/api/cars/";
        RestTemplate restTemplate = new RestTemplate();
        List<Vehicle> listOfCars = restTemplate.getForObject(urlApi, List.class);
        for (Vehicle cars: listOfCars) {
            try {
                vehicleRepository.save(cars);
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }
}
