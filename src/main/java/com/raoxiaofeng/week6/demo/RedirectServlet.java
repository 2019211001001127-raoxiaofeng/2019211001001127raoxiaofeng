package com.raoxiaofeng.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet",value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // redirect - same sever - Relative URL
        //1. start without /
        System.out.println("before redirect");

        //response.sendRedirect("index.jsp");//url-change to index.jsp
        //http://localhost:8080/2019211001001127raoxiaofeng_war_exploded/redirect
        //http://localhost:8080/2019211001001127raoxiaofeng_war_exploded/index.jsp
        System.out.println("after redirect");
        //2.start with/
        //response.sendRedirect("/2019211001001127raoxiaofeng_war_exploded/index.jsp");
        //redirect - another server - Absolute URL

        response.sendRedirect("http://www.baidu.com");
    }
}
