package com.ajit.flightreservation.controller;


import com.ajit.flightreservation.dto.ReservationUpdateRequest;
import com.ajit.flightreservation.entities.Reservation;
import com.ajit.flightreservation.repos.ReservationRepository;
import com.ajit.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ResrvationRESTController {

    @Autowired
    ReservationRepository reservationRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ResrvationRESTController.class);


    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        LOGGER.info("inside findReservation() for ID:"+id);
        Reservation reservation = reservationRepository.findById(id).get();
        return reservation;
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        LOGGER.info("inside updateReservation() for "+request);
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        Reservation updatedReservation = reservationRepository.save(reservation);
       LOGGER.info("Saving Reservation");
        return updatedReservation;
    }
}
