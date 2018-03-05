package com.coffeekong.controller;

import com.coffeekong.domain.PageMaker;
import com.coffeekong.domain.ProductVO;
import com.coffeekong.domain.SearchCriteria;
import com.coffeekong.service.ProductService;
import com.coffeekong.utils.FileUploadUtils;
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

@Controller
@RequestMapping("/manage/product")
public class ProdManageController {
	private static final Logger logger = LoggerFactory.getLogger(ProdManageController.class);
	
	@Autowired
	private ProductService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertGET(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) throws Exception {
		logger.debug("Product Manage Insert############################");
		
		model.addAttribute("content", "pminsert");
		return "/admin/adminPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/insert", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String insertPOST(SearchCriteria cri, ProductVO pvo, MultipartFile file, HttpSession session) throws Exception {
		logger.debug("Product Manage Insert############################ pvo : " + pvo.toString());
		logger.debug("originalName: " + file.getOriginalFilename());
	    logger.debug("size: " + file.getSize());
	    logger.debug("contentType: " + file.getContentType());
		
	    String relativePath = "/resources/dist/product";
	    String uploadPath = context.getRealPath(relativePath);
	    String imgUrl = relativePath + FileUploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
	    logger.debug("image Url ########################## " + imgUrl);
	    pvo.setP_img(imgUrl);
	    
	    service.insert(pvo);

		return "Success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") SearchCriteria cri, HttpSession session, Model model) throws Exception {
		logger.debug("Product Manage list############################ cri : " + cri.toString());
		
		model.addAttribute("list", service.list(cri));
		PageMaker pmk = new PageMaker();
		pmk.setCri(cri);
		pmk.setTotalCount(service.listCount(cri));
		model.addAttribute("pmk",pmk);
		
		if(cri.getKeyword() == null || cri.getKeyword() == ""){
			model.addAttribute("search", "off");
		}else{
			model.addAttribute("search", "on");
		}
		
		logger.debug("search ######################## : " + cri.getKeyword());
		
		model.addAttribute("content", "pmlist"); 
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@ModelAttribute("cri") SearchCriteria cri, int pid, HttpSession session, Model model) throws Exception {
		logger.debug("Produt Manage Detail############################ pid: " + pid);
		
		model.addAttribute("pvo", service.getByPid(pid));
		model.addAttribute("content", "pmdetail");
		return "/admin/adminPage";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@ModelAttribute("cri") SearchCriteria cri, int pid, HttpSession session, Model model) throws Exception {
		logger.debug("Product Manage Update############################ pid : " + pid);
		
		model.addAttribute("pvo", service.getByPid(pid));
		model.addAttribute("content", "pmupdate");
		return "/admin/adminPage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/save", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String updateSave(SearchCriteria cri, ProductVO pvo, MultipartFile file, HttpSession session) throws Exception {
		logger.debug("Product Manage Update Save############################ pvo : " + pvo.toString());
		
		if(file != null){
			File uploadedfile = new File(context.getRealPath("/"), pvo.getP_img());
			uploadedfile.delete();
			
		    String relativePath = "/resources/dist/product";
		    String uploadPath = context.getRealPath(relativePath);
		    String imgUrl = relativePath + FileUploadUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		    logger.debug("image Url ########################## " + imgUrl);
		    pvo.setP_img(imgUrl);
		}
		service.update(pvo);
		
		return "Success";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(SearchCriteria cri, int pid, String p_img, HttpSession session, RedirectAttributes rattr) throws Exception {
		logger.debug("Product Manage delete############################ pid : " + pid + ", p_img : " + p_img);
		
		
		File file = new File(context.getRealPath("/"), p_img);
		logger.debug("path ###############################" + file.getAbsolutePath());

		file.delete();
		service.delete(pid);
		
		rattr.addAttribute("page", cri.getPage());
	    rattr.addAttribute("perPageNum", cri.getPerPageNum());
	    rattr.addAttribute("searchType", cri.getSearchType());
	    rattr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect: /manage/product/list";
	}
}