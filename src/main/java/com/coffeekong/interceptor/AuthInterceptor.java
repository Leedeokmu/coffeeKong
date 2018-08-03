package com.coffeekong.interceptor;

import com.coffeekong.model.User;
import com.coffeekong.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			log.debug("current user is not logged in");
			saveDest(request);

			Cookie login_id = WebUtils.getCookie(request, "login_id");
			if (login_id != null) {
				User uvo = userService.getUserWithSession(login_id.getValue());
				log.debug("UserVO ###################### " + uvo);
				if (uvo != null) {
					session.setAttribute("login", uvo);
					return true;
				}
			}
			response.sendRedirect("/login");
			
			return false;
		}
		return true;
	}

	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		if (req.getMethod().equals("GET")) {
			log.debug("destination ##################" + (uri + query));
			req.getSession().setAttribute("dest", uri + query);
		}
	}
}
