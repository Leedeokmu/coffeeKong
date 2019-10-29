package com.coffeekong.controller;

import com.coffeekong.dto.Paging;
import com.coffeekong.model.User;
import com.coffeekong.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ReadUserController {
	private final ReadUserService readUserService;

	@GetMapping("/users")
	public String listUser (
			Pageable pageable,
			Model model
	) {
		log.trace("User List page");
		pageable = PageRequest.of(pageable.getPageNumber() == 0 ? pageable.getPageNumber() : pageable.getPageNumber() - 1, 5, new Sort(Sort.Direction.ASC, "id"));
		Page<User> users = readUserService.getUserList(pageable);
		Paging paging = new Paging();
		paging.setPageNo(pageable.getPageNumber() + 1);
		paging.setPageSize(pageable.getPageSize());
		paging.setTotalCount((int)users.getTotalElements());

		model.addAttribute("content", "user-list");
		model.addAttribute("paging", paging);
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/users/{userId}")
	public String getUser(
			@PathVariable("userId") Long userId,
			Model model
	) {
		log.trace("User Detail page, user : {}", userId);
		User user = readUserService.getUserById(userId);

		model.addAttribute("content", "user-detail");
		model.addAttribute("user", user);
		return "index";
	}
}
