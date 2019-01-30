package com.coffeekong.controller;

import com.coffeekong.model.User;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
public class ReadUserController {
	private final ReadUserService readUserService;

	@GetMapping("/")
	public String listUser (
			Pageable pageable,
			Model model
	) {
		pageable = PageRequest.of(pageable.getPageNumber() == 0 ? pageable.getPageNumber() : pageable.getPageNumber() - 1, 4, new Sort(Sort.Direction.DESC, "id"));
		List<User> users;

		model.addAttribute("content", "umlist");
		return "/index";
	}

	@GetMapping("/{userId}")
	public String getUser(

			String email,
			Model model
	) {
		log.debug("User Manage Detail############################ email: " + email);

		model.addAttribute("content", "user-detail");
		return "/index";
	}


}
