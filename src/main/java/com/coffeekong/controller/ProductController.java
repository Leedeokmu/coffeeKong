package com.coffeekong.controller;

import com.coffeekong.model.Product;
import com.coffeekong.model.Review;
import com.coffeekong.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/list/{category}", method = RequestMethod.GET)
	public String list(@PathVariable String category,  Model model) {
		log.debug("product list############################ category: " + category);
		List<Product> productList = productService.listByCategory(category);

		model.addAttribute("productList", productList);
		model.addAttribute("content", "list");
		return "/product/product";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(int pid, HttpSession session,Model model) {
		log.debug("product detail############################ pid: " + pid);
		
		Product pvo = productService.getByPid(pid);
		if(session.getAttribute("viewedList") == null){
			List<Product> list = new ArrayList<>();
			list.add(pvo);
			session.setAttribute("viewedList", list);
		}else{
			List<Product> list = (List<Product>) session.getAttribute("viewedList");
			Boolean flag = true;

			for(Product vo : list){
				if(vo.getId() == pid){
					flag = false;
				}
			}
			if(flag){
				list.add(pvo);
				session.setAttribute("viewedList", list);
			}
		}
		
		model.addAttribute("pvo", pvo);
		model.addAttribute("content", "detail");
		return "/product/product";
	}
	
	@ResponseBody
	@RequestMapping(value = "/review/post", method = RequestMethod.POST)
	public ResponseEntity<String> postReview(@RequestBody Review rvo){
		log.debug("post Review ################### rvo : " + rvo.toString());
		ResponseEntity<String> entity = null;
		try {
			productService.addReview(rvo);
	        entity = new ResponseEntity<>("Success", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/review/list/{pid}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listReview(@PathVariable int pid, @PathVariable int page){
		log.debug("list Review ################### pid : " + pid + ", page : " + page);
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			PageRequest pageRequest = new PageRequest(page, 5);

			Map<String, Object> map = new HashMap<>();
		    Page<Review> list = productService.listReview(pid, pageRequest);

		    map.put("list", list);
		    entity = new ResponseEntity<>(map, HttpStatus.OK);

	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/review/delete/{rid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReview(@PathVariable int rid){
		log.debug("delete Review ################### pid : " + rid);
		ResponseEntity<String> entity = null;

		try {
		      productService.deleteReview(rid);
		      entity = new ResponseEntity<>("Success", HttpStatus.OK);
	    } catch (Exception e) {
		      e.printStackTrace();
		      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
		return entity;
	}
}