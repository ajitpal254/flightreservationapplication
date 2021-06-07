package com.ajit.flightreservation.repos;

import com.ajit.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long>{
}
