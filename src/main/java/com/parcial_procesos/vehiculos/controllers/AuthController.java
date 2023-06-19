package com.parcial_procesos.vehiculos.controllers;

import com.parcial_procesos.vehiculos.models.User;
import com.parcial_procesos.vehiculos.services.UserService;
import com.parcial_procesos.vehiculos.services.UserServiceImp;
import com.parcial_procesos.vehiculos.utils.ApiResponse;
import com.parcial_procesos.vehiculos.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private UserService userService;
    private ApiResponse apiResponse;
    Map data = new HashMap<>();

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody User user){

        try{
            data.put("token",userService.login(user));
            apiResponse = new ApiResponse(Constants.USER_LOGIN,data);
            return new ResponseEntity(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse = new ApiResponse(e.getMessage(),"");
            return new ResponseEntity(apiResponse, HttpStatus.NOT_FOUND);
        }
    }
}
