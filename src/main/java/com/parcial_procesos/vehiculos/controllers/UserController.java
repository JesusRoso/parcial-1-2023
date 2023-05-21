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
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private ApiResponse apiResponse;

    @GetMapping(value = "/{id}")
    public ResponseEntity findUserById(@PathVariable Long id){
        try{
            apiResponse = new ApiResponse(Constants.REGISTER_FOUND,userService.getUser(id));
            return new ResponseEntity(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse = new ApiResponse(Constants.REGISTER_NOT_FOUND,"");
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(value = "")
    public ResponseEntity findUsers(){
        try{
            apiResponse = new ApiResponse(Constants.REGISTER_LIST,userService.allUsers());
            return new ResponseEntity(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            apiResponse = new ApiResponse(Constants.REGISTER_NOT_FOUND,"");
            return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping(value = "")
    public ResponseEntity saveUser(@RequestBody User user){
        Boolean userResp = userService.createUser(user);
        if(userResp){
            apiResponse = new ApiResponse(Constants.REGISTER_CREATED,"");
            return new ResponseEntity(apiResponse, HttpStatus.CREATED);
        }
        apiResponse = new ApiResponse(Constants.REGISTER_BAD,"");
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user){
        Boolean userResp = userService.updateUser(id, user);
        if(userResp){
            apiResponse = new ApiResponse(Constants.REGISTER_UPDATED,"");
            return new ResponseEntity(apiResponse, HttpStatus.CREATED);
        }
        apiResponse = new ApiResponse(Constants.REGISTER_UPDATE_BAD,"");
        return new ResponseEntity(apiResponse, HttpStatus.BAD_REQUEST);
    }


}
