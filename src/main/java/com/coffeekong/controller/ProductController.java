package com.coffeekong.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.Criteria;
import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.ReviewVO;
import com.coffeekong.service.ProductService;
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

@Controller
@RequestMapping("/product/*")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/list/{category}", method = RequestMethod.GET)
	public String list(@PathVariable String category,  Model model) throws Exception {
		logger.info("product list############################ category: " + category);
		
		model.addAttribute("list", service.listByCategory(category));
		model.addAttribute("content", "list");
		return "/product/product";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String deatil(int pid, HttpSession session,Model model) throws Exception {
		logger.info("product detail############################ pid: " + pid);
		
		ProductVO pvo = service.getByPid(pid);
		if(session.getAttribute("viewedList") == null){
			List<ProductVO> list = new ArrayList<ProductVO>();
			list.add(pvo);
			session.setAttribute("viewedList", list);
		}else{
			List<ProductVO> list = (List<ProductVO>) session.getAttribute("viewedList");
			Boolean flag = true;
			for(ProductVO vo: list){
				logger.info(vo.toString());
			}
			
			for(ProductVO vo : list){
				if(vo.getP_id() == pid){
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
		logger.info("post Review ################### rvo : " + rvo.toString());
		ResponseEntity<String> entity = null;
		try {
			service.addReview(rvo);
	        entity = new ResponseEntity<String>("Success", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "/review/list/{pid}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listReview(@PathVariable int pid, @PathVariable int page){
		logger.info("list Review ################### pid : " + pid + ", page : " + page);
		ResponseEntity<Map<String, Object>> entity = null;
		try {
		      Criteria cri = new Criteria();
		      cri.setPage(page);
		      cri.setPerPageNum(5);
		      PageMaker pageMaker = new PageMaker();
		      pageMaker.setCri(cri);

		      Map<String, Object> map = new HashMap<String, Object>();
		      List<ReviewVO> list = service.listReview(pid, cri);

		      map.put("list", list);

		      int replyCount = service.listReviewCount(pid);
		      pageMaker.setTotalCount(replyCount);

		      map.put("pmk", pageMaker);

		      entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);

	    } catch (Exception e) {
	      e.printStackTrace();
	      entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
	    }
		return entity;	
	}
	
	@ResponseBody
	@RequestMapping(value = "/review/delete/{rid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteReview(@PathVariable int rid){
		logger.info("delete Review ################### pid : " + rid);
		ResponseEntity<String> entity = null;
		
		try {
		      service.deleteReview(rid);
		      entity = new ResponseEntity<String>("Success", HttpStatus.OK);
	    } catch (Exception e) {
		      e.printStackTrace();
		      entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
		return entity;
	}
}