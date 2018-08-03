package com.coffeekong.controller;

import com.coffeekong.dto.LoginDTO;
import com.coffeekong.model.User;
import com.coffeekong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGET(Model model){
		log.debug("login ##########################");
	
		model.addAttribute("content", "login");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> loginPOST (@Valid @RequestBody LoginDTO dto, BindingResult error, HttpSession session ){ 
		log.debug("login ########################### dto : " + dto.toString());
		
		ResponseEntity<String> entity = null;
		
		if(error.hasErrors()){
            entity = new ResponseEntity<>("Fail", HttpStatus.OK);
		}else{
			try {
				User uvo = userService.login(dto);
				if(uvo == null){
					entity = new ResponseEntity<>("Fail", HttpStatus.OK);
				}else{
					if (session.getAttribute("login") != null) {
						
						log.debug("clear login session attr #######################");
						session.removeAttribute("login");
					}
					
					session.setAttribute("login", uvo);
					if(dto.isUseCookie()){
						int duration = 60 * 60 * 24 * 7;
						DateTime limit = new DateTime(System.currentTimeMillis() + (duration * 1000));
						userService.rmbLogin(uvo.getEmail(), session.getId(), limit);
					}
					log.debug("dest #############: "+session.getAttribute("dest"));
					entity = new ResponseEntity<>((String)session.getAttribute("dest"), HttpStatus.OK);
				}
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		log.debug("entity ############ : "+ entity);
		return entity;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,
			HttpSession session, RedirectAttributes rttr) {
		log.debug("logout #############################");
		User user = (User)session.getAttribute("login");
		if(user != null){
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie cookie = WebUtils.getCookie(request, "login_id");
			if(cookie != null){
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				userService.rmbLogin(user.getEmail(), session.getId(), DateTime.now());
			}
		}
		rttr.addAttribute("content", "");
		return "redirect:/index";
	}

}
