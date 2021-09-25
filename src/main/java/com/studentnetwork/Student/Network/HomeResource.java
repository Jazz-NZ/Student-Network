package com.studentnetwork.Student.Network;


import com.studentnetwork.Student.Network.database.*;
import com.studentnetwork.Student.Network.rest.ResItem;
import com.studentnetwork.Student.Network.rest.RestService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Optional;


@Controller
public class HomeResource {


    @Autowired
    private RestService restService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

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



        PostDB[] items = restService.getJsonAsObject(userId);

        System.out.println(items[0].getText());

        //model.addAttribute("groups",items[0].getUserId());
        model.addAttribute("name",items[0].getText());

        model.addAttribute("something",items[0].getText());

        model.addAttribute("UserInput", new UserInput());

    //    System.out.println(userInput.getPostText());

       /* GroupDB group = new GroupDB();

        group.setGroupName("FON");
       groupRepository.save(group);
*/
       // System.out.println( userRepository.findByUserName(username).get().getRoles());
        System.out.println("Your username is "+username);

        return "user";
    }


    @PostMapping("/user")
    public RedirectView greetingSubmit(@ModelAttribute UserInput userInput, Model model) {

        model.addAttribute("UserInput", userInput);
        //getting a response from groups service
        PostDB[] items = restService.getJsonAsObject(userId);

       // model.addAttribute("groups",items[0].getUserId());
        model.addAttribute("name",items[0].getText());

        model.addAttribute("something",items[0].getText());



        PostDB post = new PostDB();



        post.setText(userInput.getPostText());
        post.setUserId(userId);
        //saving a new post to a database
        postRepository.save(post).getIdPost();

        return new RedirectView("/user",true);
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
