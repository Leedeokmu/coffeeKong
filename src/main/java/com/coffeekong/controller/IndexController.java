package com.coffeekong.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class IndexController {

	@GetMapping("/index")
	public String index(Model model) {
		log.trace("index ###################################################");
		model.addAttribute("content", "");
		return "/index";
	}
	@GetMapping("/info/intro")
	public String intro(Model model) {
		log.trace("intro ###################################################");
		model.addAttribute("content", "intro");
		return "/index";
	}
	@GetMapping("/info/location")
	public String location(Model model) {
		log.trace("location ###################################################");
		model.addAttribute("content", "location");
		return "/index";
	}

	@GetMapping("/info/contact")
	public String contact(Model model) {
		log.trace("contact ###################################################");

		model.addAttribute("content", "contact");
		return "/index";
	}

	@GetMapping("learn")
	public String learn() {
		log.trace("learn ############################");

		return "/learn/learn";
	}

	@GetMapping("/learn/{type}")
	public String learn(@PathVariable String type, Model model) {
		log.trace("learn ###################################################");
		log.trace("type : {}", type);
		model.addAttribute("content",type);
		return "/learn/learn";
	}

}
