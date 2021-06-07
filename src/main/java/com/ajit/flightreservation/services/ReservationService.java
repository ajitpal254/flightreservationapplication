package com.ajit.flightreservation.services;

import com.ajit.flightreservation.dto.ReservationRequest;
import com.ajit.flightreservation.entities.Reservation;



public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
