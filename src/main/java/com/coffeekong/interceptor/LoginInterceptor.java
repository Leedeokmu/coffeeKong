package com.coffeekong.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.coffeekong.domain.UserVO;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {

		HttpSession session = request.getSession();

		UserVO uvo = (UserVO) session.getAttribute("login");
		
		if (uvo != null) {
			logger.debug("login success ####################");

			if (request.getParameter("useCookie") != null) {
				Cookie loginCookie = new Cookie("login_id", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 3);
				response.addCookie(loginCookie);
			}
//			String dest = (String) session.getAttribute("dest");
			
//			RequestDispatcher dis = request.getRequestDispatcher(dest != null ? (String) dest : "/index");
//			dis.forward(request, response);
//			response.sendRedirect(dest != null ? (String) dest : "/index");
		}
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		saveDest(request);
		return true;
	}
	
	private void saveDest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		if (query == null || "null".equals(query)){
			query = "";
		} else {
			query = "?" + query;
		}
		if (request.getMethod().equals("GET")) {
			logger.debug("destination ##################" + (uri + query));
			request.getSession().setAttribute("dest", uri + query);
		}
	}
}
