package com.transportation.AutoTransportation.repository;

import com.transportation.AutoTransportation.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByDriverId(Long id);
}
