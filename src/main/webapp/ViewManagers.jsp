<%@ page import="com.csse.service.IManagerService, com.csse.service.ManagerServiceImpl, com.csse.model.Manager, java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>View Managers</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="css/forms.css">
	<link rel="stylesheet" href="css/toast.css">
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>

        $(document).ready(function() {
            $("#openToast").toggleClass("hide view");

            $('a.exit--toast').click(function() {
                $("#openToast").fadeOut(1000, 0);
            });

            $(document).on('click', function (e) {
                if ($(e.target).closest(".notification--reminder").length === 0) {
                    $("#openToast").fadeOut(1000, 0);
                }
            });
        });
	</script>

</head>
<body>

<jsp:include page="Head.jsp"/>

<div  class="card m-5">
	<h4  style="text-transform: uppercase; font-weight: 600" class="form-titles  text-center mb-2 pt-3">View
		Managers</h4>

	<div class="m-2" >
		<table class="table table-dark table-hover">
			<thead class="text-center">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">User Name</th>
				<th scope="col">Email</th>
				<th scope="col">Site</th>
				<th scope="col">Mobile Number</th>
				<th scope="col">Actions</th>
			</tr>
			</thead>
			<tbody class="text-center">
			<%
				IManagerService iManagerService = new ManagerServiceImpl();
				ArrayList<Manager> arrayList = iManagerService.getManager();
				for(Manager manager : arrayList){
			%>
			<tr class="align-middle text-center">
				<td><%=manager.getManagerId() %></td>
				<td><%=manager.getUserName() %></td>
				<td><%=manager.getUserMail() %></td>
				<td><%=manager.getSiteName()%></td>
				<td><%=manager.getMobileNumber()%></td>
				<td>
					<div class="d-flex gap-3 justify-content-center">
						<div>
							<form method="POST" action="GetManagerServlet">
								<input type="hidden" name="user_id" value="<%=manager.getUserId()%>" />
								<input type="submit" value="Update" class="btn btn-success" />
							</form>
						</div>

						<div >
							<form method="POST" action="DeleteManagerServlet">
								<input type="hidden" name="user_id" value="<%=manager.getUserId()%>" />
								<input type="submit" value="Delete" class="btn btn-danger" />
							</form>
						</div>
					</div>
					<!-- Modal -->
					<div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel1">Modal title</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
								</div>
								<div class="modal-body">
									...
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save changes</button>
								</div>
							</div>
						</div>
					</div>

				</td>
					<% }%>
			</tbody>
		</table>
	</div>
</div>

<!-- FOOTER -->
<jsp:include page="footer.jsp"/>

<% if (request.getAttribute("Message") != null){ %>
<div class="notification--wrapper hide" id="openToast">
	<div class="notification--reminder ptb--20 text-center col-12">
		<h3 class="toast-title"><%=request.getAttribute("Message")%> <a class="exit--toast" href="javascript:void(0);">Got it.</a></h3>
	</div>
</div>
<% } %>
<script></script>
</body>
</html>
