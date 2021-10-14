<%@ page import="com.csse.model.Staff" %>
<html>
<head>
	<title>BC | Update Staff</title>
	<link rel="stylesheet" href="css/forms.css">

</head>
<body>
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<div class="container mt-3 rounded-3"  style="background-color: #ececec">
	<h3 class="form-titles text-center pt-4">Update Staff</h3>

	<%
		Staff s = (Staff) request.getAttribute("staff");
	%>
	<form method="POST" action="UpdateStaffServlet">
		<div class="d-grid gap-3 card-body pt-2 p-5">
			<div>
				<label class="form-label" for="inpustID">Supplier ID</label>
				<input type="text" class="form-control" name="supplier_id" id="inpustID" placeholder="User ID"
					   value="<%= s.getStaffId()%>"disabled>
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
				<label for="inputState" class="form-label">Position</label>
				<select name="staff_role"  id="inputState" class="form-select">
					<option  value="<%= s.getPosition()%>" selected><%= s.getPosition()%></option>
					<option  value="Account">Accountant</option>
					<option  value="Manager">Manager</option>
					<option  value="Supervisor">Supervisor</option>
				</select>
			</div>

			<div>
				<label  class="form-label">Mobile Number</label>
				<input type="text" class="form-control" id="inputNumber" name="mob_num" placeholder="0774322123"
					   value="<%= s.getMobileNumber()%>">
			</div>

			<div class="text-center">
				<button class="btn btn-dark" type="submit">Update Supplier</button>
			</div>
		</div>
	</form>

</div>
<div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp"/>
</body>
</html>
