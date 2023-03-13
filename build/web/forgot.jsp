<%-- 
    Document   : forgot
    Created on : Mar 12, 2023, 3:32:42 PM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <form action="forgot" method="post">
            <h3>Enter your email:</h3>
            <input type="text" name="email" placeholder="email"/></br>
            <h4 style="color:red">${requestScope.error}</h4>
            <input type="submit" value="Confirm"/>
        </form>
    </body>
</html>
