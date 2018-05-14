package com.coffeekong.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("content", "");
		return "index";
	}
	
	@RequestMapping(value = "info/{type}", method = RequestMethod.GET)
	public String information(@PathVariable String type, Model model) {
		log.debug("information ############################ info : " + type);
		
		model.addAttribute("content",type);
		return "index";
	}
	
	@RequestMapping(value = "learn", method = RequestMethod.GET)
	public String learn() {
		log.debug("learn ############################");
		
		return "/learn/learn";
	}
	
	@RequestMapping(value = "learn/{type}", method = RequestMethod.GET)
	public String learn(@PathVariable String type, Model model) {
		log.debug("learn ############################ type : " + type);
		
		model.addAttribute("content",type);
		return "/learn/learn";
	}
	
	
}
