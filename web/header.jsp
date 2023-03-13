<%-- 
    Document   : header
    Created on : Mar 11, 2023, 11:49:07 PM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NavBar</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <header>
            <h4 class="logo" ><a href="home">CattoShop</a></h4>
            <nav>
                <ul class="nav_links">
                    <c:if test="${sessionScope.account!=null}">
                        <c:if test="${sessionScope.account.admin==true}">
                            <li class="link_1"><a href="manage.jsp">Add Cats</a></li>
                            </c:if>
                        <li class="link_2"><a href="updateAccount.jsp">${sessionScope.account.fullname}</a></li>
                        <li class="link_3"><a href="logout">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.account==null}">            
                        <li class="link_4"><a href="login.jsp">Login</a></li>
                        </c:if>
                </ul>
            </nav>
        </header>
    </body>
</html>
