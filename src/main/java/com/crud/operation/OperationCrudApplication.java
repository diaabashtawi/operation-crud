package com.crud.operation;

import com.crud.operation.entity.Owner;
import com.crud.operation.entity.User;
import com.crud.operation.entity.Vehicle;
import com.crud.operation.repository.OwnerRepository;
import com.crud.operation.repository.UserRepository;
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

    private UserRepository userRepository;

    @Autowired
    public OperationCrudApplication(VehicleRepository vehicleRepository, OwnerRepository ownerRepository, UserRepository userRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
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

        //Username : user, Password: password
        userRepository.save(new User("user",
                "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue", "USER"));

        //Username: admin, Password: admin
        userRepository.save(new User("admin",
                "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));


    }


}
