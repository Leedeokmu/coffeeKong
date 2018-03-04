package com.coffeekong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.CartVO;
import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.domain.UserVO;
import com.coffeekong.service.OrderService;
import com.coffeekong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService uservice;
	@Autowired
	private OrderService oservice;

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateGET(HttpSession session, Model model) throws Exception {
		logger.info("User Update############################ session name: "
				+ ((UserVO) session.getAttribute("login")).getU_email());

		model.addAttribute("content", "uupdate");
		return "/index";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePOST(@Valid UserVO uvo, BindingResult result, Model model) throws Exception {
		logger.info("User Update############################ uvo: " + uvo.toString());

		if (result.hasErrors()) {
			return "/user/update";
		}
		uservice.update(uvo);
		model.addAttribute("content", "uucompl");

		return "/index";
	}

	@RequestMapping(value = "/resign", method = RequestMethod.GET)
	public String resignGET(HttpSession session, Model model) throws Exception {
		logger.info("User Resign############################ session name: "
				+ ((UserVO) session.getAttribute("login")).getU_email());

		model.addAttribute("content", "uresign");
		return "/index";
	}

	@ResponseBody
	@RequestMapping(value = "/resign", method = RequestMethod.POST)
	public ResponseEntity<String> resignPOST(@RequestBody UserVO uvo) throws Exception {
		logger.info("User Resign############################");

		ResponseEntity<String> entity = null;

		try {
			String email = uservice.checkUserPw(uvo);
			if (email != null) {
				uservice.deleteUser(email);
				entity = new ResponseEntity<String>("Success", HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("Fail", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/urcompl", method = RequestMethod.GET)
	public String resignCompl(HttpSession session, Model model) throws Exception {
		logger.info("User Resign Complete############################");

		model.addAttribute("content", "urcompl");
		return "/index";
	}

	@RequestMapping(value = "/order/list", method = RequestMethod.GET)
	public String orderList(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) throws Exception {
		logger.info("User Order############################ cri: " + cri.toString());
		
		if(session.getAttribute("login") != null){
			String email = ((UserVO)session.getAttribute("login")).getU_email();
			model.addAttribute("list", oservice.listByEmail(cri, email));
			PageMaker pmk = new PageMaker();
			pmk.setCri(cri);
			pmk.setTotalCount(oservice.listCountByEmail(cri,email));
			model.addAttribute("pmk",pmk);
		}else{
			model.addAttribute("content", "");
			return "/index";
		}
		
		if(cri.getKeyword() == null || cri.getKeyword() == ""){
			model.addAttribute("search", "off");
		}else{
			model.addAttribute("search", "on");
		}
		
		logger.info("search ######################## : " + cri.getKeyword());
		model.addAttribute("content", "uolist");
		return "/index";
	}
	
	@RequestMapping(value = "/order/detail/{oid}", method = RequestMethod.GET)
	public String orderDetail(@ModelAttribute("cri") SearchCriteria cri, @PathVariable int oid, HttpSession session, Model model) throws Exception {
		logger.info("User Order############################ session name: "
				+ ((UserVO) session.getAttribute("login")).getU_email());
		
		if(session.getAttribute("login") != null){
			model.addAttribute("ovo", oservice.getByOid(oid));
		}else{
			model.addAttribute("content", "");
			return "/index";
		}
		
		model.addAttribute("content", "uodetail");
		return "/index";
	}

	@ResponseBody
	@RequestMapping(value = "/tocart", method = RequestMethod.POST)
	public ResponseEntity<String> tocart(@RequestBody CartVO cvo, HttpSession session) throws Exception {
		logger.info("User cart############################ cvo : " + cvo.toString());

		ResponseEntity<String> entity = null;

		try {
			List<CartVO> list = (ArrayList<CartVO>) session.getAttribute("cart");

			if (list != null) {
				logger.info("session.cart############################");
				logger.info("list############################");
				for (CartVO vo : list) {
					logger.info(vo.toString());
				}

				for (Iterator<CartVO> it = list.iterator(); it.hasNext();) {
					CartVO vo = it.next();
					if (vo.getP_id() == cvo.getP_id() && vo.getType().equals(cvo.getType()) && vo.getSz().equals(cvo.getSz())) {
						it.remove();
					}
				}
			} else {
				list = new ArrayList<CartVO>();
			}
			UUID c_num  = UUID.randomUUID();
			cvo.setC_num(c_num.toString());
			
			list.add(cvo);
			session.setAttribute("cart", list);

			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("tocart", e.getStackTrace());
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart(HttpSession session, Model model) throws Exception {
		logger.info("User cart list############################");

		model.addAttribute("content", "cart");
		return "/index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/cart/update", method = RequestMethod.POST)
	public ResponseEntity<String> cartUpdate(@RequestBody CartVO cvo, HttpSession session) throws Exception {
		logger.info("User cart update############################ cvo : " + cvo.toString());

		ResponseEntity<String> entity = null;

		try {
			List<CartVO> list = (ArrayList<CartVO>) session.getAttribute("cart");

			if (list != null) {
				logger.info("list############################");
				for (CartVO vo : list) {
					logger.info(vo.toString());
				}
				for (ListIterator<CartVO> it = list.listIterator(); it.hasNext();) {
					
					CartVO vo = list.get(it.nextIndex());
					
					if(vo.getP_id() == cvo.getP_id() && vo.getType().equals(cvo.getType()) && vo.getSz().equals(cvo.getSz())){
						entity = new ResponseEntity<String>("Fail", HttpStatus.OK);
						return entity;
					}
					
					if (vo.getC_num().equals(cvo.getC_num())) {
						list.get(it.nextIndex()).setQty(cvo.getQty());
						list.get(it.nextIndex()).setType(cvo.getType());
						list.get(it.nextIndex()).setSz(cvo.getSz());
						list.get(it.nextIndex()).setSub_price(cvo.getSub_price());
						
						break;
					}
					it.next();
				}
			}
			
			session.setAttribute("cart", list);

			entity = new ResponseEntity<String>("Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("tocart", e.getStackTrace());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
}
