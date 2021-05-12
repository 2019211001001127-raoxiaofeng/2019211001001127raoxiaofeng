package com.raoxiaofeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in AuthFilter -->doFilter()-before servlet -(request come here)");
        chain.doFilter(req, resp);
        System.out.println("I am in AuthFilter -->doFilter()-after servlet -(response come here)");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
