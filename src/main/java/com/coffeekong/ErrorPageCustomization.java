package com.coffeekong;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;

public class ErrorPageCustomization extends ServerProperties {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {

        super.customize(container);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/WEB-INF/views/error/404.jsp"));
        container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/WEB-INF/views/error/500.jsp"));
        container.addErrorPages(new ErrorPage("/WEB-INF/views/error/error.jsp"));
    }
}
