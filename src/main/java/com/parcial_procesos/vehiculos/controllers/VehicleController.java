package com.parcial_procesos.vehiculos.controllers;

import com.parcial_procesos.vehiculos.services.VehicleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VehicleController {
    @Autowired
    private VehicleServiceImp vehicleServiceImp;

    @GetMapping(value = "/vehicle/{id}")
    public ResponseEntity findVehicleById(@PathVariable Long id){
        Map response = new HashMap();
        try{
            return new ResponseEntity(vehicleServiceImp.getVehicle(id), HttpStatus.OK);
        }catch (Exception e){
            response.put("status","404");
            response.put("message", "vehicle not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(value = "/vehicles")
    public ResponseEntity findVehicles(){
        Map response = new HashMap();
        try{
            return new ResponseEntity(vehicleServiceImp.allVehicles(), HttpStatus.OK);
        }catch (Exception e){
            response.put("status","404");
            response.put("message", "vehicles not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }
}
