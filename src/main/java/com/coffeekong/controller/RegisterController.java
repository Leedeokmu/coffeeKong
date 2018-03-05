package com.coffeekong.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.UserVO;
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

@Controller
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private UserService service;
	
	
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody @Valid UserVO uvo, BindingResult result) throws Exception{ 
		logger.debug("register ########################### uvo : " + uvo.toString());
		
		ResponseEntity<String> entity = null;
		
		if(result.hasErrors()){
			entity = new ResponseEntity<String>("Fail", HttpStatus.OK);
			
		}else{
			service.register(uvo);
			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.GET)
	public String registerCompl(Model model){
		logger.debug("registerSuccess ##########################");
	
		model.addAttribute("content", "regCompl");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/register/chkId", method=RequestMethod.POST)
	public ResponseEntity<String> chkId( String u_email){
		logger.debug("chkId ########################### email : " + u_email);
		ResponseEntity<String> entity = null;
		
		try {
			String email = service.checkDuplicate(u_email);
			if(email != null){
				entity = new ResponseEntity<String>("false", HttpStatus.OK);
			}else{
				entity = new ResponseEntity<String>("true", HttpStatus.OK);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
