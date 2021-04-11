<%--
  Created by IntelliJ IDEA.
  User: 19787
  Date: 2021/4/7
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<body>
    This is Count JSP page.<br>
    <%! int getCount(){
        return ++count;
    }%>
    <%! int count = 0; %>
    The page count is now (using count()): <%out.println(getCount());%>
</body>
<%@include file="footer.jsp"%>>
