package com.ch04.controller;

import com.ch04.dto.User2DTO;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class User2Controller {

    private User2Service service;

    @Autowired
    public User2Controller(User2Service user2Service){
        this.service = user2Service;
    }

    @GetMapping("/user2/register")
    public String register(){
        return "user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO dto){

        service.insertUser2(dto);

        return "redirect:/user2/register";
    }


    @GetMapping("/user2/list")
    public String list(){
        return "user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(){
        return "user2/modify";
    }

    @GetMapping("/user2/delete")
    public String delete(){
        return "user2/delete";
    }

}
