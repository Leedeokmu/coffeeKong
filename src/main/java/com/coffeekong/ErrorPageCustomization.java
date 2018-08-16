package com.coffeekong;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;

public class ErrorPageCustomization extends ServerProperties {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {

        super.customize(container);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
        container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
        container.addErrorPages(new ErrorPage("/error/error"));
    }
}
