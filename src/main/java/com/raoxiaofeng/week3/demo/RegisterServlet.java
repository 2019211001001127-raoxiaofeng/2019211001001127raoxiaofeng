package com.raoxiaofeng.week3.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

//@WebServlet(
//        urlPatterns = {"/register"}
//)


public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
//        ServletContext context = getServletContext();
//        String driver = context.getInitParameter("driver");
//        String url = context.getInitParameter("url");
//        String username = context.getInitParameter("username");
//        String password = context.getInitParameter("password");
//
//
//        try{
//            Class.forName(driver);
//            con = DriverManager.getConnection(url,username,password);
//            System.out.println("θΏζ₯ζε");
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }
        con= (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//request come here -< from method = post
    //get parameter from request



//        Integer id = Integer.valueOf(request.getParameter("id"));
        String username = request.getParameter("username");//name of input
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        //print - write into response
//        PrintWriter writer = response.getWriter();
//        writer.println("<br> username :"+username);
//        writer.println("<br> password :"+password);
//        writer.println("<br> email :"+email);
//        writer.println("<br> gender :"+gender);
//        writer.println("<br> birth Date :"+birthDate);
//        writer.close();
        try {
            String sql = "INSERT INTO usertable(username,password,email,gender,birthdate)" + "values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, birthDate);
            ps.executeUpdate();
            System.out.println("ζε₯ζε");
            ps.close();


//            String select = "SELECT * from usertable";
//            PreparedStatement ps1 = con.prepareStatement(select);
//            ResultSet rs = ps1.executeQuery();
//            String Id = null;
//            String Username = null;
//            String Password = null;
//            String Email = null;
//            String Gender = null;
//            String BirthDate = null;
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("<HTML>");
//            out.println("<HEAD><TITLE>Usingervlets</TITLE></HEAD>");
//            out.println("<BODY>");
//            out.println("<table border=\"1\">");
//            out.println("<tr>\n" +
//                    "<td>id</td>\n" + "<td>username</td>\n" + "<td>password</td>\n" + "<td>email</td>\n" +
//                    "<td>gender</td>\n" +
//                    "<td>birthDate</td>\n" +
//                    "</tr>");
//            while (rs.next()) {
//                Id = rs.getString(1);
//                Username = rs.getString(2);
//                Password = rs.getString(3);
//                Email = rs.getString(4);
//                Gender = rs.getString(5);
//                BirthDate = rs.getString(6);
//                out.println("<tr>\n" +
//                        "<td>" + Id + "</td>\n" + "<td>" + Username + "</td>\n" + "<td>" + Password + "</td>\n" + "<td>" + Email + "</td>\n" +
//                        "<td>" + Gender + "</td>\n " +
//                        "<td>" + BirthDate + "</td>\n" +
//                        "</tr>");
//            }
//            out.println("</table>");
//            out.println("</body>");
//            out.println("</html>");

           // request.setAttribute("rsname",rs);

            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            //System.out.println("I am in RegisterServlet --> doPost() --> after forward()");
//            out.close();
//            ps1.close();
//            con.close();

        //ok  - done

            response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
}
