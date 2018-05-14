package com.coffeekong.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class ErrorController {
    @RequestMapping(value="error", method=RequestMethod.GET)
    public String error(Model model){
        return "error/error";
    }

    @RequestMapping(value="404", method=RequestMethod.GET)
    public String error404(Model model){
        return "error/404";
    }

    @RequestMapping(value="500", method=RequestMethod.GET)
    public String error500(Model model){
        return "error/500";
    }
}
