package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;


import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/alterno/create")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        List<User> usuarios = userRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "login";
    }

    @PostMapping("/alterno/create")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        userRepository.save(user);
        List<User> usuarios = userRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "login";
    }
}


