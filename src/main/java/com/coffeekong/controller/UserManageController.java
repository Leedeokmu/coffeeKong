package com.coffeekong.controller;

import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/manage/user")
public class UserManageController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) {
		log.debug("User Manage list############################ cri : " + cri.toString());
		
		PageMaker pmk = new PageMaker();
		cri.setStartIdx();
		pmk.setCri(cri);
		pmk.setTotalCount(userService.listCount(cri));
		model.addAttribute("list", userService.list(cri));
		model.addAttribute("pmk",pmk);
		
		if(cri.getKeyword() == null || cri.getKeyword() == ""){
			model.addAttribute("search", "off");
		}else{
			model.addAttribute("search", "on");
		}
		
		log.debug("search ######################## : " + cri.getKeyword());
		
		model.addAttribute("content", "umlist");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cri") SearchCriteria cri, String email, HttpSession session, Model model) {
		log.debug("User Manage Detail############################ email: " + email);
		
		model.addAttribute("uvo", userService.detail(email));
		model.addAttribute("content", "umdetail");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("cri") SearchCriteria cri, @RequestParam String email, HttpSession session, Model model) {
		log.debug("User Manage Update############################ email : " + email);
		
		model.addAttribute("uvo", userService.detail(email));
		model.addAttribute("content", "umupdate");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update/save", method = RequestMethod.POST)
	public String updateSave(SearchCriteria cri, UserVO uvo, HttpSession session, RedirectAttributes rattr) {
		log.debug("User Manage list############################ uvo : " + uvo.toString());
		
		userService.update(uvo);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/user/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(SearchCriteria cri, String email, HttpSession session, RedirectAttributes rattr) {
		log.debug("User Manage delete############################ email : " + email);
		
		userService.deleteUser(email);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/user/list";
	}
}
