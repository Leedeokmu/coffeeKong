package com.coffeekong.controller;

import com.coffeekong.dto.LoginDTO;
import com.coffeekong.model.Manager;
import com.coffeekong.service.MgrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/manage")
public class ManageController {
	@Autowired
	private MgrService mgrService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model, HttpSession session){
		log.debug("manage index ##############################");
		
		if(session.getAttribute("mgr") == null){
			model.addAttribute("content", "login");
			return "/admin/adminPage";
		}
		model.addAttribute("content", "");
		return "/admin/adminPage";
		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET(Model model){
		log.debug("manage login##############################");
		
		model.addAttribute("content", "login");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST (@Valid LoginDTO dto, BindingResult error, HttpSession session, RedirectAttributes rttr ){
		log.debug("manage login ########################### dto : " + dto.toString());
		
		if(error.hasErrors()){
			rttr.addAttribute("errmsg", "CHECK THE FORM");
            return "redirect:/admin/login";
		}else{
			try {
				Manager mvo = mgrService.login(dto);
				if(mvo == null){
					rttr.addFlashAttribute("errmsg", "EMAIL & PASSWORD NOT MATCHED");
					return "redirect:/manage/login";
				}else{
					session.setMaxInactiveInterval(60*60*24);
					session.setAttribute("mgr", mvo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/manage";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,
			HttpSession session, RedirectAttributes rttr) throws Exception{ 
		log.debug("mgr logout #############################");
		Object status = session.getAttribute("mgr");
		if(status != null){
			session.removeAttribute("mgr");
			session.invalidate();
		}
		
		rttr.addAttribute("content", "");
		return "redirect:/manage";
	}
}
