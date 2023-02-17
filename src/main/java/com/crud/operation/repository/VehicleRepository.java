package com.crud.operation.repository;

import com.crud.operation.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    // Fetch Vehicle by Brand
    public List<Vehicle> findVehicleByBrand(String brand);

    public List<Vehicle> findVehicleByColor(String color);

    public List<Vehicle> findVehicleByBrandAndModel(String brand, String model);

    public List<Vehicle> findVehicleByBrandOrColor(String brand, String color);

    public List<Vehicle> findVehicleByBrandOrderByYearAsc(String brand);

    @Query(
            "select v from Vehicle v where v.brand =?1"
    )
    public List<Vehicle> findByBrand(String brand);

    @Query(
            "select v from Vehicle v where v.brand like %?1"
    )
    public List<Vehicle> findVehicleByBrandEndingWith(String brand);

}
