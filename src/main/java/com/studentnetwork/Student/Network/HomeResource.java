package com.studentnetwork.Student.Network;


import com.studentnetwork.Student.Network.database.Post;
import com.studentnetwork.Student.Network.database.PostRepository;
import com.studentnetwork.Student.Network.rest.ResItem;
import com.studentnetwork.Student.Network.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeResource {


    @Autowired
    private RestService restService;

    @Autowired
    private PostRepository postRepository;


    public HomeResource(){

    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/user",produces = {"application/json"})
    public String user(@ModelAttribute UserInput userInput, Model model){



        ResItem[] items = restService.getJsonAsObject();

        model.addAttribute("groups",items[0].getGroups());
        model.addAttribute("name",items[0].getSurname());

        model.addAttribute("something",items[0].getSurname());

        model.addAttribute("UserInput", userInput);

        System.out.println(userInput.getPostText());

        Post post = new Post();
        post.setText(userInput.getPostText());
        post.setUserId(1);
        postRepository.save(post).getIdPost();

        return "user";
    }



    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
