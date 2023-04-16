package com.parcial_procesos.vehiculos.controllers;

import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.services.VehicleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping (value = "/saveVehicle/{id}")
    public ResponseEntity saveVehicle(@PathVariable Long id){
        Map response = new HashMap();
        Boolean userResp = vehicleServiceImp.createVehicle(id);
        if(userResp){
            response.put("status","201");
            response.put("message", "Vehicle created successfully");
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        response.put("status", "400");
        response.put("message", "error creating vehicle");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/updateVehicle/{id}")
    public ResponseEntity updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){
        Map response = new HashMap();
        Boolean vehicleResp = vehicleServiceImp.updateVehicle(id, vehicle);
        if(vehicleResp){
            response.put("status","200");
            response.put("message", "vehicle updated successfully");
            return new ResponseEntity(response, HttpStatus.CREATED);
        }
        response.put("status", "400");
        response.put("message", "error updating vehicle");
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
