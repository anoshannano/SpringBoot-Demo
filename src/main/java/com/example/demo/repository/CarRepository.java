package com.example.demo.repository;

import com.example.demo.domain.Car;
import org.springframework.data.repository.CrudRepository;
public interface CarRepository extends CrudRepository<Car,Long> {

}
