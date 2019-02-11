package com.coffeekong.controller;


import com.coffeekong.service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class DeleteUserController {
    private final DeleteUserService deleteUserService;

    @DeleteMapping("/{userId}")
    public String delete(
            @PathVariable("userId") Integer userId,
            RedirectAttributes rattr
    ) {




        return "redirect:/users";
    }
}
