<%--
  Created by IntelliJ IDEA.
  User: 19787
  Date: 2021/4/7
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h2>This is my login JSP page.</h2>
<body>
    <form method="post" action="login">
        Username<input type="text" name="Username" /></br>
        Password<input type="password" name="Password" /></br>
        <input type="submit" value="Login" />
    </form>
</body>
<%@include file="footer.jsp"%>>
