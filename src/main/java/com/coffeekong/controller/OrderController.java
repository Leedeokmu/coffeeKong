package com.coffeekong.controller;

import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.UserVO;
import com.coffeekong.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	public String orderGET(Model model){
		log.debug("order get################################################");

		model.addAttribute("content", "order");
		return "/index";
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public String orderPOST(OrderVO ovo, HttpSession session, Model model){
		log.debug("order post ################################### OrderVO : "+ovo.toString());
		List<CartVO> list = (List<CartVO>) session.getAttribute("cart");
		
		try {
			String email = ((UserVO)session.getAttribute("login")).getUEmail();
			
			ovo.setUEmail(email);
			orderService.insOrder(ovo, list);
			
			
			
			session.removeAttribute("cart");
			model.addAttribute("content", "ocompl");
			return "/index";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("content","order");
		return "/index";
		
	}
}
