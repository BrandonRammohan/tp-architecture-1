package com.example.reservation.Controller;

import com.example.reservation.JsonAccess.IJsonService;
import com.example.reservation.JsonAccess.JsonService;
import com.example.reservation.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private IJsonService jsonService;

    private User activUser;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView displayVol() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (!(activUser == null)) {
            List<VolFront> vFront = jsonService.getVolsFront(activUser);
            modelAndView.addObject("vols", vFront);
            modelAndView.setViewName("dashboard");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;

    }

    @RequestMapping(value = "/reserver/{volId}", method = RequestMethod.POST)
    public ModelAndView reserve(@PathVariable("volId") int volId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (!(activUser == null)) {
            jsonService.addReservation(volId,activUser.getUserId());
            modelAndView.setViewName("dashboard");
            return modelAndView;
        }
        modelAndView.setViewName("login");
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

    @RequestMapping(value = "/reservation", method = RequestMethod.GET)
    public ModelAndView getReservations() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if (!(activUser == null)) {
            List<ReservationFront> rFront = jsonService.getReservationFront(activUser);
            modelAndView.addObject("reservations", rFront);
            modelAndView.setViewName("myReservation");
            return modelAndView;
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
