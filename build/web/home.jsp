<%-- 
    Document   : home
    Created on : Mar 12, 2023, 12:30:02 AM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CattoShop</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h2>Cat List</h2>
        <div class="container">
            <form action="search" method="get">
                <input type="text" name="search" placeholder="Name of Cat"/>
                <input type="image" src="images/loupe.png" alt="submit" width="30px" height="30px"/>
            </form>
            <div class="print-category">
                <c:forEach items="${sessionScope.listCategory}" var="c">
                    <a href="getcat?cateID=${c.cateId}">${c.cateName}</a>
                </c:forEach>
            </div>
            <div class="show-cat">
                <c:if test="${requestScope.listCatCate== null}">
                    <c:if test="${requestScope.listCat2== null}">
                        <c:forEach items="${requestScope.listCat}" var="c">
                            <c:if test="${c.status== true}">
                                <img src="${c.image}" width="130px" height="150px">
                                <c:out value="${c.catName}"/> 
                                <a href="info?catID=${c.catID}">Further Infomation</a>
                                <c:if test="${sessionScope.account.admin==true}">
                                    <a href="catupdate?catID=${c.catID}">Update</a>
                                    <a href="delete?catID=${c.catID}">Delete</a>
                                </c:if>
                            </c:if>
                        </c:forEach> 
                    </c:if> 
                    <c:if test="${requestScope.listCat2!= null}">
                        <c:forEach items="${requestScope.listCat2}" var="c">
                            <c:if test="${c.status== true}">
                                <img src="${c.image}" width="130px" height="150px">
                                <c:out value="${c.catName}"/> 
                                <a href="info?catID=${c.catID}">Further Infomation</a>
                                <c:if test="${sessionScope.account.admin==true}">
                                    <a href="catupdate?catID=${c.catID}">Update</a>
                                    <a href="delete?catID=${c.catID}">Delete</a>
                                </c:if>
                            </c:if>
                        </c:forEach>                         
                    </c:if> 
                </c:if> 
                <c:if test="${requestScope.listCatCate!= null}">
                    <c:forEach items="${requestScope.listCatCate}" var="c">
                            <c:if test="${c.status== true}">
                                <img src="${c.image}" width="130px" height="150px">
                                <c:out value="${c.catName}"/> 
                                <a href="info?catID=${c.catID}">Further Infomation</a>
                                <c:if test="${sessionScope.account.admin==true}">
                                    <a href="catupdate?catID=${c.catID}">Update</a>
                                    <a href="delete?catID=${c.catID}">Delete</a>
                                </c:if>
                            </c:if>
                    </c:forEach>                    
                </c:if> 
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
</html>
</body>
