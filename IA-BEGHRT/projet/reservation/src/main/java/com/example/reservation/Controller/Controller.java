package com.example.reservation.Controller;

import com.example.reservation.JsonAccess.IJsonService;
import com.example.reservation.JsonAccess.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*", maxAge = 3600)
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private JsonService jsonService;

    @RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String file = "src/main/resources/Json/aeroport.json";
        modelAndView.addObject("aeroports", jsonService.stringToJsonAirports(file));
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }


}
