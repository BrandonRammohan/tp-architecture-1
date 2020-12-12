package com.example.reservation.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(origins = "*", maxAge = 3600)
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

}
