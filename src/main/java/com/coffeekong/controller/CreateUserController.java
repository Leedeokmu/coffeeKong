package com.coffeekong.controller;


import com.coffeekong.model.User;
import com.coffeekong.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class CreateUserController {
    private final CreateUserService createUserService;

    @GetMapping(value = "/new")
    public String createUser(Model model) {

        model.addAttribute("content", "user-create");
        return "/index";
    }

    @PostMapping(value = "/")
    public String createUser(
            @ModelAttribute("user") User user,
            RedirectAttributes rattr) {



        return "redirect:/users";
    }

    @GetMapping("/{userId}/edit")
    public String updateUser(
            @PathVariable("userId") Integer userId,
            RedirectAttributes rattr
    ) {

        return "redirect:/user";
    }

    @PutMapping("/{userId}")
    public String updateUser(
            @PathVariable("userId") Integer userId,
            @ModelAttribute User vo,
            RedirectAttributes rattr
    ) {

        return "redirect:/user";
    }


}
