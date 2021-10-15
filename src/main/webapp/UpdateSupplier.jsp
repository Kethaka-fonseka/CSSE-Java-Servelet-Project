<%@ page import="com.csse.model.Supplier" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>BC | Update Supplier</title>
	<link rel="stylesheet" href="css/forms.css">
	<link rel="stylesheet" href="css/forms.css">


</head>
<body>
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
	<h3 class="form-titles text-center pt-4">Update Suppliers</h3>

	<%
		Supplier s = (Supplier) request.getAttribute("supplier");
	%>
	<form method="POST" action="UpdateSupplierServlet">
		<div class="d-grid gap-3 card-body pt-2 p-5">
			<div>
				<label class="form-label" for="inpustID">Supplier ID</label>
				<input type="text" class="form-control" name="supplier_id" id="inpustID" placeholder="User ID"
					   value="<%= s.getSupplierId()%>"disabled>
				<input type="hidden" class="form-control" name="user_id" id="inputuID" placeholder="User ID"
					   value="<%= s.getUserId()%>">
			</div>
			<div>
				<label class="form-label" for="inputRole">User Role</label>
				<input type="text" class="form-control" name="user_role" id="inputRole" placeholder="Supplier"
					   value="<%= s.getUserRole()%>"
					   disabled>
			</div>

			<div>
				<label class="form-label" for="inputName">User Name</label>
				<input type="text" class="form-control" name="user_name" id="inputName" placeholder="User Name"
					   value="<%= s.getUserName()%>">
			</div>
			<div>
				<label  class="form-label">Email</label>
				<input type="email" class="form-control" name="user_email" id="inputEmail"
					   placeholder="example@gmail.com"
					   value="<%= s.getUserMail() %>">
			</div>

			<div>
				<label  class="form-label">Password</label>
				<input type="password" class="form-control" name="pass" id="inputPass" value="<%= s.getUserPass()%>">
			</div>

			<div>
				<label  class="form-label">Company Name</label>
				<input type="text" class="form-control" id="inputCopmany" name="company_name" placeholder="JMIS Hardware"
					   value="<%= s.getCompanyName()%>">
			</div>

			<div>
				<label  class="form-label">Mobile Number</label>
				<input type="text" class="form-control" id="inputNumber" name="mob_num" placeholder="0774322123"
					   value="<%= s.getContactNumber()%>">
			</div>

			<div class="text-center">
				<button class="btn btn-light" type="submit">Update Supplier</button>
			</div>
		</div>
	</form>

</div>
<div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp"/>
</body>
</html>
