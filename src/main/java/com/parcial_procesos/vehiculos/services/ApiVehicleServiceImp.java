package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.models.VehicleList;
import com.parcial_procesos.vehiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiVehicleServiceImp implements ApiVehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Boolean saveVehicle(Long id) {
        String urlApi = "https://myfakeapi.com/api/cars/";
        RestTemplate restTemplate = new RestTemplate();
        VehicleList listOfCars = restTemplate.getForObject(urlApi, VehicleList.class);
        for (Vehicle cars: listOfCars.getCars()) {
            try {
                if(cars.getId().equals(id)){
                    vehicleRepository.save(cars);
                    return true;
                }
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }
}
