<%@ page import="com.csse.model.Staff, com.csse.model.Manager, com.csse.service.IManagerService, com.csse.service.ManagerServiceImpl, java.util.ArrayList, com.csse.service.SiteService, com.csse.service.SiteServiceImpl, com.csse.model.Site, java.util.List" %>
<html>
<head>
	<title>BC | Update Manager</title>
	<link rel="stylesheet" href="css/forms.css">

</head>
<body>
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<div class="container mt-3 rounded-3"  style="background-color: #ececec">
	<h3 class="form-titles text-center pt-4">Update Manager</h3>

	<%
		Manager m = (Manager) request.getAttribute("manager");
	%>
	<form method="POST" action="UpdateManagerServlet">
		<div class="d-grid gap-3 card-body pt-2 p-5">
			<div>
				<label class="form-label" for="inpustID">Supplier ID</label>
				<input type="text" class="form-control" name="mg_id" id="inpustID" placeholder="User ID"
					   value="<%= m.getManagerId()%>"disabled>
				<input type="hidden" class="form-control" name="user_id" id="inputuID" placeholder="User ID"
					   value="<%= m.getUserId()%>">
			</div>
			<div>
				<label class="form-label" for="inputRole">User Role</label>
				<input type="text" class="form-control" name="user_role" id="inputRole" placeholder="Supplier"
					   value="<%= m.getUserRole()%>"
					   disabled>
			</div>

			<div>
				<label class="form-label" for="inputName">User Name</label>
				<input type="text" class="form-control" name="user_name" id="inputName" placeholder="User Name"
					   value="<%= m.getUserName()%>">
			</div>
			<div>
				<label  class="form-label">Email</label>
				<input type="email" class="form-control" name="user_email" id="inputEmail"
					   placeholder="example@gmail.com"
					   value="<%= m.getUserMail() %>">
			</div>

			<div>
				<label  class="form-label">Password</label>
				<input type="password" class="form-control" name="pass" id="inputPass" value="<%= m.getUserPass()%>">
			</div>

			<div>
				<label for="inputState" class="form-label">Position</label>
				<select name="site_name"  id="inputState" class="form-select">
					<option  value="<%= m.getSiteName()%>" selected><%= m.getSiteName()%></option>
					<%
						SiteService iSiteService = new SiteServiceImpl();
						List<Site> arrayList = iSiteService.getSite();
						for(Site site : arrayList){
					%>

					<option value="<%=site.getSiteName()%>"><%=site.getSiteName()%></option>
					<% } %>

				</select>
			</div>

			<div>
				<label  class="form-label">Mobile Number</label>
				<input type="text" class="form-control" id="inputNumber" name="mob_num" placeholder="0774322123"
					   value="<%= m.getMobileNumber()%>">
			</div>

			<div class="text-center">
				<button class="btn btn-dark" type="submit">Update Manager</button>
			</div>
		</div>
	</form>

</div>
<div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp"/>
</body>
</html>
