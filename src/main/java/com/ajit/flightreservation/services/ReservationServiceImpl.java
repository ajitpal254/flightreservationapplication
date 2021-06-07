package com.ajit.flightreservation.services;

import com.ajit.flightreservation.controller.FlightController;
import com.ajit.flightreservation.dto.ReservationRequest;
import com.ajit.flightreservation.entities.Flight;
import com.ajit.flightreservation.entities.Passenger;
import com.ajit.flightreservation.entities.Reservation;
import com.ajit.flightreservation.repos.FlightRepository;
import com.ajit.flightreservation.repos.PassengerRepository;
import com.ajit.flightreservation.repos.ReservationRepository;
import com.ajit.flightreservation.util.EmailUtil;
import com.ajit.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ReservationServiceImpl implements ReservationService{
    
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Value("${com.ajit.flightreservationapplication.itinerary.dirpath}")
    private String Itinerary_DIR;
    @Override
    public Reservation bookFlight(ReservationRequest request) {


        Long flightId = request.getFlightId();
        LOGGER.info("Fetching Flight for flight ID:"+flightId);
        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger= new Passenger();
        passenger.setFirstName(request.getPassangerFirstName());
        passenger.setLastName(request.getPassangerLastName());
        passenger.setPhone(request.getPassangerPhone());
        passenger.setEmail(request.getPassangerEmail());
        LOGGER.info("Saving the Passenger"+passenger);
        Passenger savedPassenger = passengerRepository.save(passenger);
        
        
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);
        LOGGER.info("Saving the Reservation"+reservation);
        Reservation savedReservation = reservationRepository.save(reservation);
        String filePath=Itinerary_DIR + savedReservation.getId()+".pdf";
        LOGGER.info("Generating the Itinerary");
        pdfGenerator.generateItenerary(savedReservation,filePath);
        LOGGER.info("Sending out email");
        emailUtil.sendItinerary(passenger.getEmail(),filePath);
        return savedReservation;
    }
}
