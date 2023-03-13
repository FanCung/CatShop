<%-- 
    Document   : info
    Created on : Mar 13, 2023, 9:17:23 PM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <img src="${requestScope.cat.image}" width="260px" height="300px"/>
        <h3>
            Name: ${requestScope.cat.catName}<br/>
            Age: ${requestScope.age}<br/>
            Description: ${requestScope.cat.description}<br/>
            Price: ${requestScope.cat.price}.000VND<br/>
            <c:forEach items="${sessionScope.listCategory}" var="l">
                <c:if test="${l.cateId.equals(requestScope.cat.cateID)}">
                Type: ${l.cateName}<br/> 
                </c:if>
            </c:forEach>
                <button><a href="#" onclick="buy(${requestScope.cat.catID})">Buy</a></button>
        </h3>
    </body>
    <script>
        function buy(catID){
            var option= confirm('are you sure to buy this cat?');
            if(option===true){
                window.location.href='order?id='+catID;
            }else{
                window.location.href='home';
            }
        }
    </script>
</html>
