<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<mytags:header/>
<p>${productModel.code}</p>
<p>${productModel.name}</p>
<p>${productModel.description}</p>
<p>${productModel.price}</p>