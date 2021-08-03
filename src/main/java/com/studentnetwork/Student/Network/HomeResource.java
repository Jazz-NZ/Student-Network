package com.studentnetwork.Student.Network;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeResource {


    @RequestMapping("/")
    public String home(){
        return "index.html";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {"application/json"})
    public String user(Model model){


        model.addAttribute("something", "govnooo");

        return "user.html";
    }


    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
