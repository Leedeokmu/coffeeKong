package com.coffeekong.controller;


import com.coffeekong.service.DeleteUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class DeleteUserController {
    private final DeleteUserService deleteUserService;

    @DeleteMapping("/users/{userId}")
    public @ResponseBody
    ResponseEntity<Map<String, Object>> delete (
            @PathVariable("userId") Long userId
    ) {
        ResponseEntity<Map<String, Object>> entity = null;
        Map<String,  Object> map = new HashMap<>();
        String id;

        try{
            deleteUserService.deleteUser(userId);
            entity = new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception e){
            log.error(e.getMessage());
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
