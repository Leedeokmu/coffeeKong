package com.coffeekong.controller;

import com.coffeekong.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		model.addAttribute("list", productService.listByCategory(category));
		model.addAttribute("content", "list");
		return "/product/product";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String deatil(int pid, HttpSession session,Model model) {
		log.debug("product detail############################ pid: " + pid);
		
		ProductVO pvo = productService.getByPid(pid);
		if(session.getAttribute("viewedList") == null){
			List<ProductVO> list = new ArrayList<ProductVO>();
			list.add(pvo);
			session.setAttribute("viewedList", list);
		}else{
			List<ProductVO> list = (List<ProductVO>) session.getAttribute("viewedList");
			Boolean flag = true;
			for(ProductVO vo: list){
				log.debug(vo.toString());
			}
			
			for(ProductVO vo : list){
				if(vo.getPId() == pid){
					flag = false;
				}
			}
			if(flag){
//				for (ListIterator<ProductVO> it = list.listIterator(); it.hasNext();) {
//					it.remove();
//
//					
//					
//					it.next();
//				}
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
	public ResponseEntity<String> postReview(@RequestBody ReviewVO rvo){
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
		      Criteria cri = new Criteria();
		      cri.setPage(page);
		      cri.setPerPageNum(5);
		      PageMaker pageMaker = new PageMaker();
		      pageMaker.setCri(cri);

		      Map<String, Object> map = new HashMap<>();
		      List<ReviewVO> list = productService.listReview(pid, cri);

		      map.put("list", list);

		      int replyCount = productService.listReviewCount(pid);
		      pageMaker.setTotalCount(replyCount);

		      map.put("pmk", pageMaker);

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