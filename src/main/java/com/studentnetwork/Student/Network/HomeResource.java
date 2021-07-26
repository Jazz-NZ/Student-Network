package com.studentnetwork.Student.Network;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeResource {


    @GetMapping("/")
    public String home(){
        return("<h1>Welcome<h1>");
    }

    @RequestMapping("/user")
    public String user(){
        return "user.html";
    }


    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
