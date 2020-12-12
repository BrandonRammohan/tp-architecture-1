package com.example.reservation.Controller;

import com.example.reservation.JsonAccess.IJsonService;
import com.example.reservation.JsonAccess.JsonService;
import com.example.reservation.Model.Aeroport;
import com.example.reservation.Model.User;
import com.example.reservation.Model.Vol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.sound.midi.Soundbank;

@CrossOrigin(origins = "*", maxAge = 3600)
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private JsonService jsonService;

    private User activUser;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView displayVol() throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        String airportfile = "src/main/resources/Json/aeroport.json";
        String volfile = "src/main/resources/Json/vol.json";

        Aeroport aeroports[] = jsonService.stringToJsonAirports(airportfile);
        Vol vols[] = jsonService.stringToJsonVols(volfile);

      /*  Object object[] = new Object[vols.length];
        for (int i = 0; i<vols.length; i++) {
            object[i] = vols[i];
            System.out.println(object[i]);
        }*/

        modelAndView.addObject("vols", vols);
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/reserver/{volId}", method = RequestMethod.POST)
    public ModelAndView reserve(@PathVariable("volId") int volId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("Id du vol = " + volId);

        jsonService.addReservation(volId,activUser.getUserId());

        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public String loginAction(@RequestParam("email") String email) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        activUser = jsonService.addUser(email);
        return "redirect:dashboard";
    }
}
