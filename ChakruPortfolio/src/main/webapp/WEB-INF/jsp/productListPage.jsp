<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<mytags:header/>
<c:forEach var="product" items="${productModel}">
	<tr>
		<td>${product.code}</td>
		<td>${product.name}</td>
		<td>${product.description}</td>
		<td>${product.price}</td>
	</tr>
</c:forEach	>