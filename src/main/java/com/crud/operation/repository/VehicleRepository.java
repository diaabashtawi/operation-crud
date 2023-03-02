package com.crud.operation.repository;

import com.crud.operation.entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    // Fetch Vehicle by Brand
    public List<Vehicle> findVehicleByBrand(@Param("brand") String brand);

    public List<Vehicle> findVehicleByColor(@Param("color") String color);

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
