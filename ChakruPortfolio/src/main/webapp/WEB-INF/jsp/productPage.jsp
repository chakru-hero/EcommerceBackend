<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags" %>
<mytags:header/>

<div style="text-align:center">${productModel.name}</div>
<br>
<div style="text-align:center">code:${productModel.code}</div>
<br>
<div style="text-align:center">description:${productModel.description}</div>
<br>
<div style="text-align:center">price:$${productModel.price}</div>
<br>
<div style="text-align:center"><button>Add to Cart</button></div>

<div class="footer"><mytags:footer/></div>