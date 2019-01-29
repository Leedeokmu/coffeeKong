package com.coffeekong.controller;

import com.coffeekong.model.User;
import com.coffeekong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserManageController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String list (Model model) {

		model.addAttribute("content", "umlist");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("pageable") Pageable pageable, String email, HttpSession session, Model model) {
		log.debug("User Manage Detail############################ email: " + email);
		
		model.addAttribute("uvo", userService.detail(email));
		model.addAttribute("content", "umdetail");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam String email, HttpSession session, Model model) {
		log.debug("User Manage Update############################ email : " + email);
		
		model.addAttribute("uvo", userService.detail(email));
		model.addAttribute("content", "umupdate");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update/save", method = RequestMethod.POST)
	public String updateSave(User uvo, RedirectAttributes rattr) {
		log.debug("User Manage list############################ uvo : " + uvo.toString());
		User user = userService.update(uvo);
		
	    rattr.addAttribute("user", user);

		return "redirect:/manage/user/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(String email, HttpSession session, RedirectAttributes rattr) {
		log.debug("User Manage delete############################ email : " + email);
		
		return "redirect:/manage/user/list";
	}
}
