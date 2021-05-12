package com.raoxiaofeng.week5.demo;

import com.raoxiaofeng.dao.UserDao;
import com.raoxiaofeng.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login",
        initParams = {
                @WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url", value = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb"),
                @WebInitParam(name = "username", value = "sa"),
                @WebInitParam(name = "password", value = "raoxiaofeng0810")
        }
)
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        //now move jdbc code in dao - MVC design
        //write mvc code
        //use model and dao
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,Username,Password);
            //forward - jsp
            if(user!=null){
                //add code for remember me
                String rememberMe = request.getParameter("rememberMe");//1=checked
                if(rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie = new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe",rememberMe);
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                //week 8 demo #2
                HttpSession session =request.getSession();
                System.out.println("session id -->"+session.getId());
                session.setMaxInactiveInterval(10);
                //week 8 demo #1 - used cookie for session
                //create cookie
                //step1: create an object of cookie class
                //Cookie c = new Cookie("sessionid",""+user.getId());//sessionid - user- id
                //step2: set age of cookie
                //c.setMaxAge(10*60);//in sec
                //step3: add cookie into response
                 //   response.addCookie(c);
                //week 8 0-change request(one page) to session - so we can get session attribute in many jsp page - login.jsp and header.jsp
                session.setAttribute("user",user);//set user info in session
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//        String sql = "select id,username,password,email,gender,birthdate from usertable where username='"+Username+" 'and password='"+Password+"'";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            PrintWriter Out = response.getWriter();
//            if(rs.next()){
//                //week 5 code
//                //Out.println("Login Success!!!");
//                //Out.println("Welcome!"+Username);
//                request.setAttribute("id",rs.getInt("id"));
//                request.setAttribute("username",rs.getString("username"));
//                request.setAttribute("password",rs.getString("password"));
//                request.setAttribute("email",rs.getString("email"));
//                request.setAttribute("gender",rs.getString("gender"));
//                request.setAttribute("birthdate",rs.getString("birthdate"));
//
//                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
//            }else{
//                //Out.println("Username or Password Error!!!");
//                request.setAttribute("message","Username or Password Error!!!");
//                request.getRequestDispatcher("login.jsp").forward(request,response);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);//call doPost

        //when click login menu - request is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
