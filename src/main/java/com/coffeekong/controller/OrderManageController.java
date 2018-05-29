package com.coffeekong.controller;

import com.coffeekong.domain.OrderVO;
import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/manage/order")
public class OrderManageController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) {
		log.debug("Order Manage list############################ cri : " + cri.toString());

		PageMaker pmk = new PageMaker();
		cri.setStartIdx();
		pmk.setCri(cri);
		pmk.setTotalCount(orderService.listCount(cri));

		model.addAttribute("pmk",pmk);
		
		if(cri.getKeyword() == null || cri.getKeyword() == ""){
			model.addAttribute("search", "off");
		}else{
			model.addAttribute("search", "on");
		}
		
		log.debug("search ######################## : " + cri.getKeyword());

		model.addAttribute("list", orderService.list(cri));
		model.addAttribute("content", "omlist");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cri") SearchCriteria cri, int oid, HttpSession session, Model model) {
		log.debug("Order Manage Detail############################ oid: " + oid);
		
		model.addAttribute("ovo", orderService.getByOid(oid));
		model.addAttribute("content", "omdetail");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("cri") SearchCriteria cri, int oid, HttpSession session, Model model) {
		log.debug("Order Manage Update############################ oid : " + oid);
		
		model.addAttribute("ovo", orderService.getByOid(oid));
		model.addAttribute("content", "omupdate");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update/save", method = RequestMethod.POST)
	public String updateSave(SearchCriteria cri, OrderVO ovo, HttpSession session, RedirectAttributes rattr) {
		log.debug("Order Manage list############################ ovo : " + ovo.toString());
		
		orderService.update(ovo);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/order/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(SearchCriteria cri, int oid, HttpSession session, RedirectAttributes rattr) {
		log.debug("Order Manage delete############################ oid : " + oid);
		
		orderService.delete(oid);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/order/list";
	}
	
	@RequestMapping(value = "/update/state", method = RequestMethod.POST)
	public String updateState(SearchCriteria cri, int oid, String state, HttpSession session, RedirectAttributes rattr) {
		log.debug("Order Manage Update State############################ oid : " + oid + ", state : " + state);
		
		orderService.updateState(oid, state);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/order/list";
	}

}
