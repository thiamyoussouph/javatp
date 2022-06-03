package com.myapp.mywebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Usercontroller {
    @Autowired private  UserSErvice sErvice;
    @GetMapping("/users")
    public String showlist(Model model){
        List<user> lisusers= sErvice.listall();
     model.addAttribute("lisusers",lisusers);

        return "users";
    }
    @GetMapping("/users/new")
    public String addnew(Model model){
        model.addAttribute("user",new user());
        model.addAttribute("pageTItre","ajout");
        return "formulaire";
    }
    @PostMapping("/users/save")
    public  String ajou(user user){

        sErvice.save(user);
        return "redirect:/users";
    }
     @GetMapping("/users/edit{id}")
    public  String showeditforme(@PathVariable("id") Integer id ,Model model){
         try {
           user user =  sErvice.get(id);
           model.addAttribute("user" ,user);
             model.addAttribute("pageTItre","modifier(id:" +id+")");
       return "formulaire";
         } catch (userNotfoundException e) {

             return "redirect:/users";
         }

     }
    @GetMapping("/users/delete{id}")
    public  String deleteuser(@PathVariable("id") Integer id){
        try {
           sErvice.delete(id);
        } catch (userNotfoundException e) {


        }
        return "redirect:/users";
    }

}
