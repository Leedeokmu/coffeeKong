package com.coffeekong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.UserVO;
import com.coffeekong.dto.LoginDTO;
import com.coffeekong.service.UserService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET(Model model){
		logger.info("login ##########################"); 
	
		model.addAttribute("content", "login");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<String> loginPOST (@Valid @RequestBody LoginDTO dto, BindingResult error, HttpSession session ){ 
		logger.info("login ########################### dto : " + dto.toString());
		
		ResponseEntity<String> entity = null;
		
		if(error.hasErrors()){
            entity = new ResponseEntity<String>("Fail", HttpStatus.OK);
		}else{
			try {
				UserVO uvo = service.login(dto);
				if(uvo == null){
					entity = new ResponseEntity<String>("Fail", HttpStatus.OK);
				}else{
					if (session.getAttribute("login") != null) {
						
						logger.info("clear login session attr #######################");
						session.removeAttribute("login");
					}
					
					session.setAttribute("login", uvo);
					if(dto.isUseCookie()){
						int duration = 60 * 60 * 24 * 7;
						Date limit = new Date(System.currentTimeMillis() + (duration * 1000));
						service.rmbLogin(uvo.getU_email(), session.getId(), limit);
					}
					logger.info("dest #############: "+(String)session.getAttribute("dest"));
					entity = new ResponseEntity<String>((String)session.getAttribute("dest"), HttpStatus.OK);
				}
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
		}
		logger.info("entity ############ : "+ entity);
		return entity;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response,
			HttpSession session, RedirectAttributes rttr) throws Exception{ 
		logger.info("logout #############################");
		Object status = session.getAttribute("login");
		if(status != null){
			UserVO uvo = (UserVO)status;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie cookie = WebUtils.getCookie(request, "login_id");
			if(cookie != null){
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				service.rmbLogin(uvo.getU_email(), session.getId(), new Date());
			}
		}
		rttr.addAttribute("content", "");
		return "redirect:/index";
	}

}
