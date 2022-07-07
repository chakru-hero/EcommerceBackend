<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<mytags:header/>


<c:forEach var="product" items="${productModel}">
<br>
<div style="text-align:center;"><mytags:productdetails productdetails="${product}"/></div>
<br>
</c:forEach>


<div class="footer"><mytags:footer/></div>