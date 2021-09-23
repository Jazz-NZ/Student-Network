package com.studentnetwork.Student.Network;


import com.studentnetwork.Student.Network.database.Post;
import com.studentnetwork.Student.Network.database.PostRepository;
import com.studentnetwork.Student.Network.rest.ResItem;
import com.studentnetwork.Student.Network.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class HomeResource {


    @Autowired
    private RestService restService;

    @Autowired
    private PostRepository postRepository;

    public static String username;
    public static int userId;

    public HomeResource(){

    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET,produces = {"application/json"})
    public String user(Model model){



        ResItem[] items = restService.getJsonAsObject();

        model.addAttribute("groups",items[0].getGroups());
        model.addAttribute("name",items[0].getSurname());

        model.addAttribute("something",items[0].getSurname());

        model.addAttribute("UserInput", new UserInput());

    //    System.out.println(userInput.getPostText());



        System.out.println("Your username is "+username);

        return "user";
    }


    @PostMapping("/user")
    public RedirectView greetingSubmit(@ModelAttribute UserInput userInput, Model model) {

        model.addAttribute("UserInput", userInput);
        ResItem[] items = restService.getJsonAsObject();

        model.addAttribute("groups",items[0].getGroups());
        model.addAttribute("name",items[0].getSurname());

        model.addAttribute("something",items[0].getSurname());


        Post post = new Post();



        post.setText(userInput.getPostText());
        post.setUserId(userId);
        postRepository.save(post).getIdPost();

        return new RedirectView("/user",true);
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
