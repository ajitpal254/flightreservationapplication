package com.ajit.flightreservation.controller;


import com.ajit.flightreservation.entities.User;
import com.ajit.flightreservation.repos.UserRepository;
import com.ajit.flightreservation.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER =  LoggerFactory.getLogger(UserController.class);
    @Autowired
    private BCryptPasswordEncoder encoder;;
    @RequestMapping("/showReg")
    public String showRegisterationPage(){
        LOGGER.info("inside showRegisterationPage()");
        return "login/registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user){
        LOGGER.info("inside register()"+user);
        //user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login/login";
    }
    @RequestMapping("/showLogin")
    public String showLoginPage(){
        LOGGER.info("inside showLoginPage()");

        return "login/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        ModelMap modelMap) {
        boolean loginResponse = securityService.login(email, password);
        LOGGER.info("Inside login() and the email is: " + email);
        if (loginResponse) {
            return "findFlights";
        } else {
            modelMap.addAttribute("msg", "Invalid user name or password .Please try again.");
        }

        return "login/login";

    }
}