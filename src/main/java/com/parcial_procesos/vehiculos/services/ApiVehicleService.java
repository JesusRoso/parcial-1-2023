package com.parcial_procesos.vehiculos.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.parcial_procesos.vehiculos.models.Vehicle;

import java.util.List;

public interface ApiVehicleService {
    Boolean saveVehicle(Long id) throws JsonProcessingException;
}
