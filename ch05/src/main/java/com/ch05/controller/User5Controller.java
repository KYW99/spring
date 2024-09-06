package com.ch05.controller;

import com.ch05.dto.User5DTO;
import com.ch05.service.User5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User5Controller {

    private final User5Service user5Service;

    @Autowired
    public User5Controller(User5Service user5Service) {
        this.user5Service = user5Service;

    }

    @GetMapping("/user5/list")
    public String list(Model model) {
        List<User5DTO> users = user5Service.selectUser5s();
        model.addAttribute("users", users);

        return "user5/list";
    }

    @GetMapping("/user5/register")
    public String Register() {
        return "user5/register";
    }

    @PostMapping("/user5/register")
    public String Register(User5DTO user5DTO) {
        user5Service.insertUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/modify")
    public String Modify(@RequestParam("seq") int seq, Model model) {
        User5DTO user5DTO = user5Service.selectUser5(seq);
        model.addAttribute("user5DTO", user5DTO);
        return "user5/modify";
    }

    @PostMapping("/user5/modify")
    public String Modify(User5DTO user5DTO) {
        user5Service.updateUser5(user5DTO);
        return "redirect:/user5/list";
    }

    @GetMapping("/user5/delete")
    public String Delete(@RequestParam("seq") int seq) {
        user5Service.deleteUser5(seq);
        return "redirect:/user5/list";
    }
}
