<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<mytags:header/>

<c:forEach var="product" items="${cart.products}">
<br>
<div style="text-align:center;"><mytags:productdetails productdetails="${product}"/></div>
<br>
</c:forEach>

<div><h1>User Details</h1></div>
<div>Name:${user.username}</div>
<br>
<div>Email:${user.email}</div>
<br>
<div>UserID:${user.id}</div>