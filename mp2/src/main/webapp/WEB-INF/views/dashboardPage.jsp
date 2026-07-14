<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <h2>Our Product Catalog</h2>
    <a href="cart">view shopping cart</a>

    <c:forEach items="${allProducts}" var="prod">
        
        <div style="border: 1px solid black; padding: 10px; margin-bottom: 10px;">
            <h3>Name: ${prod.name}</h3>
            <p>Price: ₹${prod.price}</p>
            <p>Stock Available: ${prod.quantity}</p>
            
            <form action="cart/add" method="POST">
			    <input type="hidden" name="productId" value="${prod.id}">
			    
			    <label>Qty:</label>
			    <input type="number" name="quantity" value="1" min="1" max="${prod.quantity}">
			    
			    <button type="submit">Add to Cart</button>
			</form>
			
			<%-- <form action="cart/add" method="post">
				<input type="hidden" name="productId" value="${prod.id}"> 
				
			</form> --%>
            
            </div>

    </c:forEach>

</body>
</html>