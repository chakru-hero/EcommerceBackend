<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="productdetails" required="true" type="com.portfolio.chakru.models.ProductModel"%>

<div style="text-align:center">${productdetails.name}</div>
<div style="text-align:center">code:${productdetails.code}</div>
<div style="text-align:center">price:$${productdetails.price}</div>
<div><button>Add to Cart</button></div>
