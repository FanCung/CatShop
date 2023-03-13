<%-- 
    Document   : manage.jsp
    Created on : Mar 13, 2023, 12:06:09 AM
    Author     : anh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Cat</title>
    </head>
    <body>
        <form action="manage"  method="post" enctype='multipart/form-data'>
            <input type="text" name="catName" placeholder="Name of cat"/></br>
            <input type="text" name="yob" placeholder="Year of birth"/></br>
            <input type="radio" name="gender" checked value="1"/>Male 
            <input type="radio" name="gender" value="0"/>Female</br>
            <input type='file' name='userFile'></br>
            <input type="text" name="description" placeholder="description"/></br>
            <input type="text" name="price" placeholder="price"/></br>
            <label for="category">Choose a category:</label>
            <select name ="cateID" id="category">
                <c:forEach items="${sessionScope.listCategory}" var="c">
                    <option value="${c.cateId}">${c.cateName}</option>
                </c:forEach>
            </select>
            <h4 style="color:red">${requestScope.error}</h4>
            <input type="submit" value="Add"/>
        </form>
    </body>
</html>
