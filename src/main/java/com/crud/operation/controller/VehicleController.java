package com.crud.operation.controller;

import com.crud.operation.entity.Vehicle;
import com.crud.operation.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @RequestMapping(
            value = "/vehicles"
    )
    public Iterable<Vehicle> getAllVehicle(){
        return vehicleRepository.findAll();
    }
}
