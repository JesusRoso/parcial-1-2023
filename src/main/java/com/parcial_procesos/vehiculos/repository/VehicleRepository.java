package com.parcial_procesos.vehiculos.repository;

import com.parcial_procesos.vehiculos.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
