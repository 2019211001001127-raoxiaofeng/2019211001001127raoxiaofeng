package com.raoxiaofeng.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//use @webservlet - no web.xml code
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url", value = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb"),
                @WebInitParam(name = "username", value = "sa"),
                @WebInitParam(name = "password", value = "raoxiaofeng0810")
        },loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        // connection within do get
        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        // String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb";
        //   String username = "sa";
        //   String password = "raoxiaofeng0810";

        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");


        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init()-->" + con);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // connection within do get -- many times - bad way
        System.out.println("I am in doGet()");
        String sql = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()){

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();//when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
