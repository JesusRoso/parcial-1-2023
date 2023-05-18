package com.parcial_procesos.vehiculos.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.models.VehicleList;
import com.parcial_procesos.vehiculos.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiVehicleServiceImp implements ApiVehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Override
    public Boolean saveVehicle(Long id) throws JsonProcessingException {
        String urlApi = "https://myfakeapi.com/api/cars/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> car = restTemplate.getForEntity(urlApi, String.class);
        ObjectMapper objectMapper = new ObjectMapper();

        Vehicle vehicle = objectMapper.readValue(car.getBody().substring(7), Vehicle.class);
        if(vehicleRepository.findById(id).isEmpty()){
            vehicleRepository.save(vehicle);
            return true;
        }
        return false;
    }
}
