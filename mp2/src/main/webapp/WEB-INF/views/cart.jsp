<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Shopping Cart</title>
    <style>
        .cart-container { width: 60%; margin: 50px auto; font-family: Arial, sans-serif; }
        .cart-item { border-bottom: 1px solid #ccc; padding: 15px 0; display: flex; justify-content: space-between; }
        .empty-message { text-align: center; color: #777; margin-top: 30px; }
        .grand-total { text-align: right; margin-top: 20px; font-size: 1.3em; font-weight: bold; }
    </style>
</head>
<body>

    <div class="cart-container">
        <h2>Your Shopping Cart</h2>

        <c:choose>
            <c:when test="${empty cart}">
                <div class="empty-message">
                    <h3>Your cart is empty!</h3>
                    <p><a href="products">Go back to product catalog</a></p>
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${cart}" var="item">
                    <div class="cart-item">
                        <div>
                            <h3>${item.product.name}</h3>
                            <p>Price: ₹${item.product.price}</p>
                            <p>Quantity: ${item.quantity}</p>
                        </div>
                        <div>
                            <h4>Total: ₹${item.product.price * item.quantity}</h4>
                        </div>
                    </div>
                </c:forEach>

                <div class="grand-total">
                    Grand Total: ₹${total}
                </div>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>