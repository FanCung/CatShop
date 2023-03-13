<%-- 
    Document   : login
    Created on : Mar 11, 2023, 6:52:56 PM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <form action="login" method="post">
            <h3>
                <input type="text" name="email" placeholder="email"/></br>
                <input type="password" name="password" placeholder="password"/></br>
            <small><a href="forgot.jsp">Forgot?</a></small>
            </h3>
            <h4 style="color:red">${requestScope.error}${requestScope.m_error}</h4>
            <input type="submit" value="Login"/>
        </form>
        <h3>Not registered?<a href="register.jsp">Create an account</a></h3>
    </body>
</html>
