<%@ page import="com.csse.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<%--Roboto Condense Google Fotn API added--%>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,300;0,400;0,500;1,300;1,400;1,500&display=swap" rel="stylesheet">
	<%--Bootstrap 5.1.2  --%>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
	<%--Custom CSS--%>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/head.css">
	<%--Place your kit's code here --%>
	<script src="https://kit.fontawesome.com/dcd509c6ce.js" crossorigin="anonymous"></script>

</head>
<body>
<%--admin navbar--%>
<%
   User user = (User)session.getAttribute("user");
   if(user.getUserRole().equals("admin")) {
%>
<nav class="navbar navbar-expand-lg navbar-light">
	<div class=" container nav-con" >
		<a class="navbar-brand" href="#"><img src="images/LogoLG.png" alt="BCConstuction Logo" width="220"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarSupportedContent1" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent1">
			<ul class="navbar-nav ms-auto  mb-lg-0s m-auto">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="supplierDropdown1" role="button"
					   data-bs-toggle="dropdown" aria-expanded="false">
						Suppliers
					</a>
					<ul class="dropdown-menu " aria-labelledby="supplierDropdown1">
						<li><a class="dropdown-item" href="AddSupplierDetails.jsp">Add Suppliers</a></li>
						<li><a class="dropdown-item" href="ViewSupplier.jsp">View Suppliers</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="staffDropdown1" role="button"
					   data-bs-toggle="dropdown" aria-expanded="false">
						Staff Members
					</a>
					<ul class="dropdown-menu " aria-labelledby="staffDropdown1">
						<li><a class="dropdown-item" href="AddStaffMembers.jsp">Add Staff Members</a></li>
						<li><a class="dropdown-item" href="ViewStaff.jsp">View Staff Members</a></li>
					</ul>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="siteManagersDropdown1" role="button"
					   data-bs-toggle="dropdown" aria-expanded="false">
						Site Managers
					</a>
					<ul class="dropdown-menu " aria-labelledby="siteManagersDropdown1">
						<li><a class="dropdown-item" href="AddSiteManager.jsp">Add Site Managers</a></li>
						<li><a class="dropdown-item" href="ViewManagers.jsp">View Site Managers</a></li>
					</ul>
				</li>
			</ul>

			<form  class="ms-auto mt-3" method="POST" action="LogoutServlet">
			<button type="submit"  class="btn sign-out-btn ">Sign Out</button>
			</form>

		</div>
	</div>
</nav>
<% } else if(user.getUserRole().equals("supplier"))

{

%>
<nav class="navbar navbar-expand-lg navbar-light">
	<div class=" container nav-con" >
		<a class="navbar-brand" href="#"><img src="images/LogoLG.png" alt="BCConstuction Logo" width="220"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarSupportedContent2" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent2">
			<ul class="navbar-nav ms-auto  mb-lg-0s m-auto">
				<li class="nav-item dropdown">
					<a class="nav-link" href="#">Orders</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link" href="#">Deliveries</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="itemDropdown" role="button"
					   data-bs-toggle="dropdown" aria-expanded="false">
						Manage Items
					</a>
					<ul class="dropdown-menu " aria-labelledby="itemDropdown">
						<li><a class="dropdown-item" href="AddItemsDetails.jsp">Add Items</a></li>
						<li><a class="dropdown-item" href="ViewItems.jsp">View Items</a></li>
					</ul>
				</li>
			</ul>

			<form  class="ms-auto mt-3" method="POST" action="LogoutServlet">
				<button type="submit"  class="btn sign-out-btn ">Sign Out</button>
			</form>

		</div>
	</div>
</nav>
<% } else if(user.getUserRole().equals("manager"))

{

%>
<nav class="navbar navbar-expand-lg navbar-light">
	<div class=" container nav-con" >
		<a class="navbar-brand" href="#"><img src="images/LogoLG.png" alt="BCConstuction Logo" width="220"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarSupportedContent3" aria-controls="navbarSupportedContent2"
				aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent3">
			<ul class="navbar-nav ms-auto  mb-lg-0s m-auto">
				<li class="nav-item dropdown">
					<a class="nav-link" href="#">Orders</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link" href="#">Deliveries</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="requisitionDropdown" role="button"
					   data-bs-toggle="dropdown" aria-expanded="false">
					  Inventory Transactions
					</a>
					<ul class="dropdown-menu " aria-labelledby="itemDropdown">
						<li><a class="dropdown-item" href="AddRequisition.jsp">Add Requisitions</a></li>
						<form action="GetAllRequisitionsServlet" method="post">
						<li><button class="dropdown-item" type="submit" >View Requisitions</button></li>
						</form>
					</ul>
				</li>
			</ul>

			<form  class="ms-auto mt-3" method="POST" action="LogoutServlet">
				<button type="submit"  class="btn sign-out-btn ">Sign Out</button>
			</form>

		</div>
	</div>
</nav>
<% } else
{
%>
<nav class="navbar navbar-expand-lg navbar-light">
	<div class=" container nav-con" >
		<a class="navbar-brand" href="#"><img src="images/LogoLG.png" alt="BCConstuction Logo" width="220"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarSupportedContent4" aria-controls="navbarSupportedContent3"
				aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent4">
			<ul class="navbar-nav ms-auto  mb-lg-0s m-auto">
				<li class="nav-item dropdown">
					<a class="nav-link" href="#">Approvals</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="siteDropdown2" role="button"
					   data-bs-toggle="dropdown" aria-expanded="false">
						Site Management
					</a>
					<ul class="dropdown-menu " aria-labelledby="siteDropdown2">
						<li><a class="dropdown-item" href="AddSiteDetails.jsp">Add Sites</a></li>
						<li><a class="dropdown-item" href="BudgetList.jsp">View Sites</a></li>
					</ul>
				</li>
			</ul>

			<form  class="ms-auto mt-3" method="POST" action="LogoutServlet">
				<button type="submit"  class="btn sign-out-btn ">Sign Out</button>
			</form>

		</div>
	</div>
</nav>
<% } %>
<%--Banners for each user role--%>
<div class="container-fluid bg-light">
	<div class="container">
	<div class="row align-items-center gx-5 ">
		<div class="col-lg-5  col-md-5 d-lg-block d-md-block d-none bg-light">
			<div  class="d-flex p-2 justify-content-end">
				<img class="banner-logo flipper img-fluid " src="images/LogoLG-B.png" alt="Image" >
			</div>
		</div>
		<div class="col-lg-7 col-md-7">
			<div class="d-flex p-2  justify-content-center">
				<img src="images/new/worker.png" height="700" alt="Image">
			</div>
		</div>
	</div>
	</div>
</div>



<%--    Bootstrap@5.1.2 JavaScript plugin --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-kQtW33rZJAHjgefvhyyzcGF3C5TFyBQBA13V1RKPf4uH+bwyzQxZ6CmMZHmNBEfJ" crossorigin="anonymous"></script>
</body>
</html>
