package com.coffeekong.controller;

import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.model.Order;
import com.coffeekong.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/manage/order")
public class OrderManageController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteria cri, Model model) {
		log.debug("Order Manage list############################ cri : " + cri.toString());

		if(cri.getKeyword() == null || cri.getKeyword() == ""){
			model.addAttribute("search", "off");
		}else{
			model.addAttribute("search", "on");
		}
		
		log.debug("search ######################## : " + cri.getKeyword());

		Page<Order> orderList = orderService.list(cri);
		model.addAttribute("list", orderList);
		model.addAttribute("content", "omlist");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cri") SearchCriteria cri, int oid, Model model) {
		log.debug("Order Manage Detail############################ oid: " + oid);
		
		model.addAttribute("ovo", orderService.getByOid(oid));
		model.addAttribute("content", "omdetail");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("cri") SearchCriteria cri, int id, Model model) {
		log.debug("Order Manage Update############################ oid : " + id);
		
		model.addAttribute("ovo", orderService.getByOid(id));
		model.addAttribute("content", "omupdate");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update/save", method = RequestMethod.POST)
	public String updateSave(@ModelAttribute("cri") SearchCriteria cri, Order ovo, RedirectAttributes rattr) {
		log.debug("Order Manage list############################ ovo : " + ovo.toString());
		
		Order order = orderService.update(ovo);
		rattr.addAttribute("ovo", order);
		return "redirect:/manage/order/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("cri") SearchCriteria cri, Integer id, RedirectAttributes rattr) {
		log.debug("Order Manage delete############################ oid : " + id);
		
		orderService.delete(id);
		
		return "redirect:/manage/order/list";
	}
	
	@RequestMapping(value = "/update/state", method = RequestMethod.POST)
	public String updateState(@ModelAttribute("cri") SearchCriteria cri, int oid, String state, RedirectAttributes rattr) {
		log.debug("Order Manage Update State############################ oid : " + oid + ", state : " + state);
		
		orderService.updateState(oid, state);
//		rattr.addAttribute("page", cri.getPage());
//	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
//	    rattr.addAttribute("searchType", cri.getSearchType());
//	    rattr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/manage/order/list";
	}
}
