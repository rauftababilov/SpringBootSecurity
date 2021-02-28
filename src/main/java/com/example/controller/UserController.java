package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("showUser")
    public String showUserForm(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user/show_user";
    }

    @GetMapping("usersList")
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users_list";
    }
}
