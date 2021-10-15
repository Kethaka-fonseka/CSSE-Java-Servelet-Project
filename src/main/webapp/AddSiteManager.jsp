<%@ page import="com.csse.service.SiteServiceImpl, com.csse.model.Site, com.csse.service.SiteService, java.util.ArrayList, java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>BC | Add Site Manager</title>
	<link rel="stylesheet" href="css/forms.css">
</head>
<body>
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
	<h3 class="form-titles text-center pt-4">Add Site Manager</h3>
	<form method="POST" action="AddManagerServlet">
		<div class="d-grid gap-3 card-body pt-2 p-5">
				<%
            String message= (String) request.getAttribute("message");

            if(message!=null)  {
                %>
				<%=message%>
				<%
                    }
                %>

			<div>
		<div class="d-grid gap-3 card-body pt-2 p-5">
			<div>
				<label class="form-label" for="inputName">User Name</label>
				<input type="text" class="form-control" name="user_name" id="inputName" placeholder="User Name">
			</div>
			<div>
				<label  class="form-label">Email</label>
				<input type="email" class="form-control" name="user_email" id="inputEmail"
					   placeholder="example@gmail.com">
			</div>

			<div>
				<label  class="form-label">Password</label>
				<input type="password" class="form-control" name="pass" id="inputPass" >
			</div>


			<div>
				<label for="inputState" class="form-label">Allocated Site</label>
				<select name="site_name" id="inputState" class="form-select">

					<option selected >Choose...</option>
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
				<input type="number" class="form-control" id="inputNumber" name="mob_num" placeholder="0774322123">
			</div>

			<div class="text-center">
				<button class="btn btn-light" type="submit">Add Member</button>
			</div>
		</div>
	</form>

</div>
<div>
	<!-- FOOTER -->
	<jsp:include page="footer.jsp"/>
</body>
</html>
