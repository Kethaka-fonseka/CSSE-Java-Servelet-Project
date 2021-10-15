<%@ page import="com.csse.service.SiteServiceImpl, com.csse.model.Site, com.csse.service.SiteService, java.util.ArrayList, java.util.List, com.csse.service.IRegisterService, com.csse.service.RegisterServiceImpl, com.csse.model.Supplier, com.csse.model.Requisition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>BC | Checkout</title>
	<link rel="stylesheet" href="css/forms.css">
</head>
<body>
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<% Requisition requisition = (Requisition) request.getAttribute("requisition"); %>
<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
	<h3 class="form-titles text-center pt-4">Checkout</h3>
	<form method="POST" action="PlaceOrderServlet">
		<div class="d-grid gap-3 card-body pt-2 p-5">

			<div>
				<label class="form-label" for="inputName">Item Name</label>
				<input type="text" class="form-control" name="itemName" id="inputName" value="<%=requisition.getItemName()%>"
					   placeholder="User Name">
			</div>
			<div>
				<label  class="form-label">Quantity</label>
				<input type="text" class="form-control" name="qty" id="inputEmail"  value="<%=requisition.getItemQty()%>">
			</div>

			<div>
				<label  class="form-label">Total Price</label>
				<input type="text" class="form-control" name="total" id="inputPass"
					   value="<%=requisition.getTotalPrice()%>">
			</div>


			<div>
				<label for="inputState" class="form-label">Supplier</label>
				<select name="supplier" id="inputState" class="form-select">

					<option selected >Choose...</option>
					<%
						IRegisterService iRegisterService = new RegisterServiceImpl();
						ArrayList<Supplier> arrayList = iRegisterService.getSuppliers();
						for(Supplier supplier : arrayList){
					%>
					<option value="<%=supplier.getCompanyName()%>"><%=supplier.getCompanyName()%></option>
					<% } %>
				</select>
			</div>


			<div class="text-center">
				<button class="btn btn-light" type="submit">Place Order</button>
			</div>
		</div>

	</form>

</div>
<div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp"/>
</body>
</html>
