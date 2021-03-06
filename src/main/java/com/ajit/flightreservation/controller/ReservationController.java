package com.ajit.flightreservation.controller;


import com.ajit.flightreservation.dto.ReservationRequest;
import com.ajit.flightreservation.entities.Flight;
import com.ajit.flightreservation.entities.Reservation;
import com.ajit.flightreservation.repos.FlightRepository;
import com.ajit.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    FlightRepository flightRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);


    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){

        LOGGER.info("Inside showCompleteReservation() invoked with Flight ID:"+flightId);
        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight",flight);
        LOGGER.info("Flight is:"+flight);
        return "completeReservation";
    }


    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request,ModelMap modelMap){
        LOGGER.info("Inside completeReservation()"+request);

        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg","Reservation created succesfully and the id is "+reservation.getId());
        return "reservationConfirmation";
    }


}
