<%-- 
    Document   : updateAccount
    Created on : Mar 12, 2023, 9:29:05 PM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Account</title>
    </head>
    <body>
        <form action="update" >
            <input type="text" name="email" placeholder="email" value="${sessionScope.account.email} "readonly></br>
            <input type="text" name="name" placeholder="fullname" value="${sessionScope.account.fullname}"/></br>
            <input type="text" name="phone" placeholder="phone number" value="${sessionScope.account.phone}"/></br>
            <input type="text" name="address" placeholder="address" value="${sessionScope.account.address}"/></br>
            <input type="text" name="question" placeholder="security question" value="${sessionScope.account.question}"/></br>
            <input type="text" name="answer" placeholder="security answer" value="${sessionScope.account.answer}"/></br>
            <h4 style="color:red">${requestScope.error}</h4>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
