package com.crud.operation;

import com.crud.operation.entity.Owner;
import com.crud.operation.entity.Vehicle;
import com.crud.operation.repository.OwnerRepository;
import com.crud.operation.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class OperationCrudApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OperationCrudApplication.class);

    private VehicleRepository vehicleRepository;

    private OwnerRepository ownerRepository;

    @Autowired
    public OperationCrudApplication(VehicleRepository vehicleRepository, OwnerRepository ownerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ownerRepository = ownerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OperationCrudApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 =
                new Owner(
                        "John",
                        "Johanson"
                );

        Owner owner2 =
                new Owner(
                        "Mary",
                        "Robinson"
                );

        Vehicle vehicle1 =
                new Vehicle(
                        "Ford",
                        "Mustang",
                        "Red",
                        "ADB-1289",
                        2022,
                        59000,
                        owner1
                );

        Vehicle vehicle2 =
                new Vehicle(
                        "Toyota",
                        "Prius",
                        "Silver",
                        "TYT-5952",
                        2017,
                        39000,
                        owner2
                );

        Vehicle vehicle3 =
                new Vehicle(
                        "Nissan",
                        "Leaf",
                        "White",
                        "SSJ-1005",
                        2019,
                        29000,
                        owner2
                );

        ownerRepository.saveAll(Arrays.asList(owner1, owner2));
        vehicleRepository.saveAll(Arrays.asList(vehicle1, vehicle2, vehicle3));

    }
}
