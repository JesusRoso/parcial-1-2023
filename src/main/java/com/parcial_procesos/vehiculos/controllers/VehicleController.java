package com.parcial_procesos.vehiculos.controllers;

import com.parcial_procesos.vehiculos.models.Vehicle;
import com.parcial_procesos.vehiculos.services.VehicleServiceImp;
import com.parcial_procesos.vehiculos.utils.Constants;
import com.parcial_procesos.vehiculos.utils.JWTUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Api( tags = "Vehicle")
public class VehicleController {
    @Autowired
    private VehicleServiceImp vehicleServiceImp;
    @Autowired
    private JWTUtil jwtUtil;
    public Boolean isValidateToken(String token){
        try{
            if(jwtUtil.getKey(token) != null){
                return true;
            }
            return  false;
        }catch (Exception e){
            return  false;
        }
    }
    @GetMapping(value = "/vehicle/{id}")
    public ResponseEntity findVehicleById(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        Map response = new HashMap();
        try{
            if(!isValidateToken(token))
            {
                return new ResponseEntity(Constants.INVALID_TOKEN, HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity(vehicleServiceImp.getVehicle(id), HttpStatus.OK);
        }catch (Exception e){
            response.put("status","404");
            response.put("message", "vehicle not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/vehicles")
    public ResponseEntity findVehicles(@RequestHeader(value = "Authorization") String token){
        Map response = new HashMap();
        try{
            if(!isValidateToken(token))
            {
                return new ResponseEntity(Constants.INVALID_TOKEN, HttpStatus.UNAUTHORIZED);
            }
            return new ResponseEntity(vehicleServiceImp.allVehicles(), HttpStatus.OK);
        }catch (Exception e){
            response.put("status","404");
            response.put("message", "vehicles not found!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping (value = "/saveVehicle/{id}/{id_user}")
    public ResponseEntity saveVehicle(@RequestHeader(value = "Authorization") String token,@PathVariable Long id,@PathVariable Long id_user){
        Map<String, String> response = new HashMap<>();
        try {
            if(!isValidateToken(token))
            {
                return new ResponseEntity(Constants.INVALID_TOKEN, HttpStatus.UNAUTHORIZED);
            }
            Boolean vehicleResp = vehicleServiceImp.createVehicle(id, id_user);
            if(vehicleResp){
                response.put("status","201");
                response.put("message", "Vehicle created successfully");
                return new ResponseEntity(response, HttpStatus.CREATED);
            }
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            response.put("status", "400");
            response.put("message", "error creating vehicle");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(value = "/updateVehicle/{id}")
    public ResponseEntity updateVehicle(@RequestHeader(value = "Authorization") String token,@PathVariable Long id, @RequestBody Vehicle vehicle){
        Map response = new HashMap();
        try{
            if(!isValidateToken(token))
            {
                return new ResponseEntity(Constants.INVALID_TOKEN, HttpStatus.UNAUTHORIZED);
            }
            Boolean vehicleResp = vehicleServiceImp.updateVehicle(id, vehicle);
            if(vehicleResp){
                response.put("status","200");
                response.put("message", "vehicle updated successfully");
                return new ResponseEntity(response, HttpStatus.CREATED);
            }
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        catch (Exception e){
            response.put("status", "400");
            response.put("message", "error updating vehicle");
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }
}
