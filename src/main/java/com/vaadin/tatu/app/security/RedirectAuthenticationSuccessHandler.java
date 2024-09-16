package com.vaadin.tatu.app.security;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.context.annotation.ApplicationScope;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.tatu.app.Application;

/**
 * Redirects to the application after successful authentication.
 */
@SpringComponent
@ApplicationScope
public class RedirectAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    private final String location;

    @Autowired
    private ServletContext servletContext;

    public RedirectAuthenticationSuccessHandler() {
        location = Application.APP_URL;
    }

    private String getAbsoluteUrl(String url) {
        final String relativeUrl;
        if (url.startsWith("/")) {
            relativeUrl = url.substring(1);
        } else {
            relativeUrl = url;
        }
        return servletContext.getContextPath() + "/" + relativeUrl;
    }

    @Override
    public void onAuthenticationSuccess(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response,
            Authentication authentication)
            throws IOException, jakarta.servlet.ServletException {
        response.sendRedirect(getAbsoluteUrl(location));
    }

}
