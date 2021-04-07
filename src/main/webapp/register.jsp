<%--
  Created by IntelliJ IDEA.
  User: 19787
  Date: 2021/3/24
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
    <h1>This is my register JSP page.</h1>
    <form method="post" action="register"><!--within doPost() in servlet-->
        username<input type="text" name="username" /></br>
        password<input type="password" name="password" /></br>
        Email<input type="text" name="email" /></br>
        Gender:<input type="radio" name="gender" value="Male"/>Male<input type="radio" name="gender" value="Female">Female</br>
        Date of Birth :<input type="text" name="birthDate" /></br>
        <input type="submit" value="Register" />
    </form>
<%@include file="footer.jsp"%>
