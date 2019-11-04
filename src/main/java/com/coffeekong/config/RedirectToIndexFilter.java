package com.coffeekong.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class RedirectToIndexFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String requestURI = ((HttpServletRequest) request).getRequestURI();

        // skip api call
        if (requestURI.startsWith("/api")) {
            chain.doFilter(request, response);
            return;
        }
        // bypass static resources
        if (
                requestURI.startsWith("/public") ||
                requestURI.endsWith(".map") ||
                requestURI.endsWith(".js") ||
                requestURI.endsWith(".css") ||
                requestURI.endsWith(".json") ||
                requestURI.endsWith(".png") ||
                requestURI.endsWith(".jpg") ||
                requestURI.endsWith(".jpeg") ||
                requestURI.endsWith(".ico") ||
                requestURI.endsWith(".svg") ||
                requestURI.endsWith(".txt")
        ) {
            chain.doFilter(request, response);
            return;
        }

        // forward to index page except for /api and static resources
        request.getRequestDispatcher("/").forward(request, response);
    }
}