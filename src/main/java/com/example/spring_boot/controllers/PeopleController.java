package com.example.spring_boot.controllers;


import com.example.spring_boot.models.User;
import com.example.spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final UserService userService;


    public PeopleController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getAllUsers(Model model){
        //Получим всех людей из DAO и передадим на отображение в представление

       model.addAttribute("people", userService.getAllUsers());

        return  "people/index"; //папка people и файл index.html
   }




    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        // Получим одного человека по id из DAO и передадим на отображение в предствление

        model.addAttribute("user", userService.getUserById(id));

        return "people/show"; //папка people и файл show.html
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {

        return "people/new"; //папка people и файл new.html
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.getUserById(id));
        return "people/edit";
    }



    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);

        return "redirect:/people";

    }

}
