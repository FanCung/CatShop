<%-- 
    Document   : Forgot2Servlet
    Created on : Mar 12, 2023, 6:06:34 PM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <form action="forgot2" method="post">
            <h3>${sessionScope.user.question}</h3>
            <input type="text" name="answer" placeholder="your answer"/></br>
            <input type="password" name="password" placeholder="password"/></br>
            <input type="password" name="re_pass" placeholder="re-enter your password"/></br>
            <h4 style="color:red">${requestScope.error}</h4>
            <input type="submit" value="Confirm"/>
        </form>
    </body>
</html>
