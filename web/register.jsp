<%-- 
    Document   : register
    Created on : Mar 12, 2023, 10:42:20 AM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="register" method="post">

                <input type="text" name="email" placeholder="email"/></br>
                <input type="password" name="password" placeholder="password"/></br>
                <input type="password" name="re_pass" placeholder="re-enter your password"/></br>
                <input type="text" name="name" placeholder="fullname"/></br>
                <input type="text" name="phone" placeholder="phone number"/></br>
                <input type="text" name="address" placeholder="address"/></br>
                <input type="text" name="question" placeholder="security question"/></br>
                <input type="text" name="answer" placeholder="security answer"/></br>

            <h4 style="color:red">${requestScope.error}</h4>
            <input type="submit" value="Sign Up"/>
        </form>
        <h3>registered?<a href="login.jsp">Sign in</a></h3>
    </body>
</html>
