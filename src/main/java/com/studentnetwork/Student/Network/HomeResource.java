package com.studentnetwork.Student.Network;


import com.studentnetwork.Student.Network.database.*;

import com.studentnetwork.Student.Network.rest.RestService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class HomeResource {


    private final RestService restService;




    public static String username;
    public static int userId;

    //bolji nacin bi bio da se iz baze poziva id korisnika na osnovu imena

    private String groupName = "";

    public HomeResource(RestService restService){

        this.restService = restService;

    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET,produces = {"application/json"})
    public String user(Model model){



        PostDB[] items = restService.getJsonAsObject(userId);

        model.addAttribute("userID",userId);


        model.addAttribute("posts",items);


        model.addAttribute("UserInput", new UserInput());
        model.addAttribute("Search", new Search());

    //    System.out.println(userInput.getPostText());

       /* GroupDB group = new GroupDB();

        group.setGroupName("FON");
       groupRepository.save(group);
*/
       // System.out.println( userRepository.findByUserName(username).get().getRoles());
        System.out.println("Your username is "+username);

        return "user";
    }

    @PostMapping("/results")
    public RedirectView searchResultsPost(@ModelAttribute Search search){

        groupName = search.getSearchInput();

        System.out.println(search.getSearchInput());
        return new RedirectView("/results",true);
    }

    @RequestMapping(value = "/results",method = RequestMethod.GET,produces = {"application/json"})
    public String resultsGet(Model model){


    // treba dodati preuzimanje rezultata iz grupa

        GroupDB[] groups = restService.getGroupsAsObject(groupName);

        model.addAttribute("groups",groups);
        model.addAttribute("userID",userId);

        return "results";
    }


    @PostMapping("/user")
    public RedirectView greetingSubmit(@ModelAttribute UserInput userInput,  Model model) {

        model.addAttribute("UserInput", userInput);
        //getting a response from groups service
        PostDB[] items = restService.getJsonAsObject(userId);

        model.addAttribute("posts",items);

        model.addAttribute("userID",userId);


        System.out.println("Postavaljenje novo posta sa /user stranice");

        return new RedirectView("/user",true);
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome Admin<h1>");
    }






}
