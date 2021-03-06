package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private UserService userService;

    @GetMapping("usersList")
    public String usersList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/users_list";
    }

    @GetMapping("addUserForm")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", userService.findAllRoles());
        return "admin/add_user";
    }

    @PostMapping("addUser")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin/usersList";
    }

    @GetMapping("editUserForm/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", userService.findAllRoles());
        return "admin/edit_user";
    }

    @PostMapping("editUser/{id}")
    public String editUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin/usersList";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin/usersList";
    }
}
