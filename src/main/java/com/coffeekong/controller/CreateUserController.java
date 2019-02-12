package com.coffeekong.controller;


import com.coffeekong.model.User;
import com.coffeekong.service.CreateUserService;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class CreateUserController {
    private final CreateUserService createUserService;
    private final ReadUserService readUserService;

    @GetMapping(value = "/users/add")
    public String createUser(Model model) {

        model.addAttribute("content", "user-add");
        return "/index";
    }

    @PostMapping(value = "/users")
    public @ResponseBody
    ResponseEntity<Map<String, Object>> createUser(
            @ModelAttribute("user") User user,
            @RequestParam("pwdConfirm") String pwdConfirm
    ) {
        ResponseEntity<Map<String, Object>> entity = null;
        Map<String,  Object> map = new HashMap<>();

        if(!user.getPwd().equals(pwdConfirm)){
            map.put("error", "PASSWORD NOT MATCHED");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        try{
            User addUser = createUserService.register(user);
            entity = new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/users/{userId}/edit")
    public String updateUser(
            @PathVariable("userId") Long userId,
            Model model
    ) {
        User user = readUserService.getUserById(userId);

        model.addAttribute("content", "user-update");
        model.addAttribute("user", user);
        return "/index";
    }

    @PutMapping("/users/{userId}")
    public @ResponseBody
    ResponseEntity<Map<String, Object>> updateUser(
            @PathVariable("userId") Long userId,
            @ModelAttribute User vo
    ) {
        ResponseEntity<Map<String, Object>> entity = null;
        Map<String,  Object> map = new HashMap<>();

        try{
            User updateUser = createUserService.update(userId, vo);
            entity = new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            map.put("error", e.getMessage());
            entity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        return entity;
    }


}
