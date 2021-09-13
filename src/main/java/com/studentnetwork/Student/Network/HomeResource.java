package com.studentnetwork.Student.Network;

import com.google.gson.Gson;
import com.studentnetwork.Student.Network.rest.Group;
import com.studentnetwork.Student.Network.rest.ResItem;
import com.studentnetwork.Student.Network.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeResource {


    @Autowired
    private RestService restService;


    public HomeResource(){

    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = {"application/json"})
    public String user(Model model){




        ResItem[] items = restService.getJsonAsObject();

        String ispis = "default";


        model.addAttribute("something", items[0].getName());

        return "user";
    }


    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
