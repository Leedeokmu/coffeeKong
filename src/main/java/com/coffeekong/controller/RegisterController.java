package com.coffeekong.controller;

import com.coffeekong.domain.UserVO;
import com.coffeekong.service.UserService;
import lombok.extern.slf4j.Slf4j;
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

import javax.validation.Valid;

@Slf4j
@Controller
public class RegisterController {
	@Autowired
	private UserService userService;
	
	
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody @Valid UserVO uvo, BindingResult result) {
		log.debug("register ########################### uvo : " + uvo.toString());
		
		ResponseEntity<String> entity = null;
		
		if(result.hasErrors()){
			entity = new ResponseEntity<String>("Fail", HttpStatus.OK);
			
		}else{
			userService.register(uvo);
			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/registerSuccess", method=RequestMethod.GET)
	public String registerCompl(Model model){
		log.debug("registerSuccess ##########################");
	
		model.addAttribute("content", "regCompl");
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value="/register/chkId", method=RequestMethod.POST)
	public ResponseEntity<String> chkId( String u_email){
		log.debug("chkId ########################### email : " + u_email);
		ResponseEntity<String> entity = null;
		
		try {
			String email = userService.checkDuplicate(u_email);
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
