<%@ page isELIgnored="false" %>
<form action="${pageContext.request.contextPath}/product/save" method="post">
	ProductId:<input type="text" value="${obj.id}" name="id" readonly><br>
	Name:<input type="text" value="${obj.name}" name="name" readonly><br>
	Price:<input type="text" value="${obj.price}" name="price" ><br>
	<input type="submit" value="updatePrice">
</form>