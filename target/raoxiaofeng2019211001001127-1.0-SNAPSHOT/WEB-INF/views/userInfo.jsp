<%@ page import="com.raoxiaofeng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 19787
  Date: 2021/4/11
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
    <h1>UserInfo</h1>
    <%
        //read cookies
        Cookie [] allCookies = request.getCookies();//all cookies
        for(Cookie c:allCookies){
            //get one by one
            out.println("<br>"+c.getName()+" --- "+c.getValue());
        }
    %>
    <%
        User u = (User) session.getAttribute("user");
    %>
    <table>
        <tr>
            <td>Username:</td><td><%=u.getUsername()%></td>
        </tr>
        <tr>
            <td>Password:</td><td><%=u.getPassword()%></td>
        </tr>
        <tr>
            <td>Email:</td><td><%=u.getEmail()%></td>
        </tr>
        <tr>
            <td>Gender:</td><td><%=u.getGender()%></td>
        </tr>
        <tr>
            <td>Birthdate:</td><td><%=u.getBirthdate()%></td>
        </tr>
    </table>
    <a href="updateUser">Update</a>
<%@include file="footer.jsp"%>
