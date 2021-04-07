<%--
  Created by IntelliJ IDEA.
  User: 19787
  Date: 2021/4/6
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    //java code here
    public void jspInit(){
        System.out.println("i am in jspinit()");
    }

%>
<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am in jspservice()");%>
</body>
</html>
<!-- service -->
<%!
    public void jspDestroy(){
        System.out.println("i am in jspDestroy()");
    }
%>
