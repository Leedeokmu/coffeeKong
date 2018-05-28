package com.coffeekong.controller;

import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.service.ProductService;
import com.coffeekong.utils.FileUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Slf4j
@Controller
@RequestMapping("/manage/product")
public class ProdManageController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ServletContext context;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) {
		log.debug("Product Manage Insert############################");
		
		model.addAttribute("content", "pminsert");
		return "/admin/adminPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String insertPOST(SearchCriteria cri, ProductVO pvo, MultipartFile file, HttpSession session) throws Exception{
		log.debug("Product Manage Insert############################ pvo : " + pvo.toString());
		log.debug("originalName: " + file.getOriginalFilename());
	    log.debug("size: " + file.getSize());
	    log.debug("contentType: " + file.getContentType());
		
	    String relativePath = "/resources/dist/product";
	    String uploadPath = context.getRealPath(relativePath);
	    String imgUrl = relativePath + FileUploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
	    log.debug("image Url ########################## " + imgUrl);
	    pvo.setImg(imgUrl);
	    
	    productService.insert(pvo);

		return "Success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) {
		log.debug("Product Manage list############################ cri : " + cri.toString());
		
		model.addAttribute("list", productService.list(cri));
		PageMaker pmk = new PageMaker();
		pmk.setCri(cri);
		pmk.setTotalCount(productService.listCount(cri));
		model.addAttribute("pmk",pmk);
		
		if(cri.getKeyword() == null || cri.getKeyword() == ""){
			model.addAttribute("search", "off");
		}else{
			model.addAttribute("search", "on");
		}
		
		log.debug("search ######################## : " + cri.getKeyword());
		
		model.addAttribute("content", "pmlist"); 
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cri") SearchCriteria cri, int pid, HttpSession session, Model model) {
		log.debug("Produt Manage Detail############################ pid: " + pid);
		
		model.addAttribute("pvo", productService.getByPid(pid));
		model.addAttribute("content", "pmdetail");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("cri") SearchCriteria cri, int pid, HttpSession session, Model model) {
		log.debug("Product Manage Update############################ pid : " + pid);
		
		model.addAttribute("pvo", productService.getByPid(pid));
		model.addAttribute("content", "pmupdate");
		return "/admin/adminPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/save", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String updateSave(SearchCriteria cri, ProductVO pvo, MultipartFile file, HttpSession session) throws  Exception{
		log.debug("Product Manage Update Save############################ pvo : " + pvo.toString());
		
		if(file != null){
			File uploadedfile = new File(context.getRealPath("/"), pvo.getImg());
			uploadedfile.delete();
			
		    String relativePath = "/resources/dist/product";
		    String uploadPath = context.getRealPath(relativePath);
		    String imgUrl = relativePath + FileUploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		    log.debug("image Url ########################## " + imgUrl);
		    pvo.setImg(imgUrl);
		}
		productService.update(pvo);
		
		return "Success";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(SearchCriteria cri, int pid, String p_img, HttpSession session, RedirectAttributes rattr) {
		log.debug("Product Manage delete############################ pid : " + pid + ", p_img : " + p_img);
		
		
		File file = new File(context.getRealPath("/"), p_img);
		log.debug("path ###############################" + file.getAbsolutePath());

		file.delete();
		productService.delete(pid);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/product/list";
	}
}