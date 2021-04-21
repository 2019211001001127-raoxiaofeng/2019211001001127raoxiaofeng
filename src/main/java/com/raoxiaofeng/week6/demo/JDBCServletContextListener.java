package com.raoxiaofeng.week6.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//tell tomcat this class is a listener class -how ?
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //like a main() method for this web app
        //called when tomcat start
        //use this method to create JDBC Connection when tomcat start
        ServletContext context = sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");


        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("i am in JDBCServletContextListener--> contextInitialized()"+con);//when?
            context.setAttribute("con",con);//name=value
        } catch (ClassNotFoundException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //end point of web app
        //this method called when tomcat stop
        System.out.println("i am in contextDestroyed()");//when this line print?
        sce.getServletContext().removeAttribute("con");
    }
}
