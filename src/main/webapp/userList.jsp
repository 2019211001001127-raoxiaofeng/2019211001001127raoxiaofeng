<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 19787
  Date: 2021/4/11
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
<%@include file="header.jsp"%>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <td>id</td><td>username</td><td>password</td>  <td>email</td><td>gender</td><td>birthDate</td>
        </tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("rsname");
            if(rs == null){

        %>
        <tr>
            <td>
                No Data!!!
            </td>
        </tr>
        <%}else {
            while (rs.next()) {
                out.println("<tr>\n" +
                        "<td>" + rs.getInt("id") + "</td>\n" + "<td>" + rs.getString("username") + "</td>\n" + "<td>"
                        + rs.getString("password") + "</td>\n" + "<td>" + rs.getString("email") + "</td>\n" +
                        "<td>" + rs.getString("gender") + "</td>\n " +
                        "<td>" + rs.getString("birthdate") + "</td>\n" +
                        "</tr>");
            }
        }
        %>
    </table>
<%@include file="footer.jsp"%>
