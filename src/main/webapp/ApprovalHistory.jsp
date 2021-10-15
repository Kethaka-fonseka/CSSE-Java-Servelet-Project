<%@ page import="com.csse.service.IRequisitionService, com.csse.service.RequisitionServiceimpl, com.csse.model.Requisition, java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>BC | Approval History </title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Rubik:ital,wght@0,300;0,400;0,500;1,300;1,400;1,500&display=swap" rel="stylesheet">
	<%--Bootstrap 5.1.2  --%>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-uWxY/CJNBR+1zjPWmfnSnVxwRheevXITnMqoEIeG1LJrdI0GlVs/9cVSyPYXdcSF" crossorigin="anonymous">
	<%--Custom CSS--%>
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
<%--HEADER--%>
<jsp:include page="Head.jsp"/>

<div class="card m-5">
	<h4 style="text-transform: uppercase; font-weight: 600"
		class="form-titles  text-center mb-2 pt-3">Approval History</h4>
	<div class="m-2">
		<table class="table table-dark table-hover">
			<thead class="text-center">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Req Type</th>
				<th scope="col">Item</th>
				<th scope="col">Quantity</th>
				<th scope="col">Rate</th>
				<th scope="col">Amount</th>
				<th scope="col">Status</th>
				<th scope="col">Actions</th>

			</tr>
			</thead>
			<tbody class="align-middle text-center">
			<%
				IRequisitionService iRequisitionService = new RequisitionServiceimpl();
				ArrayList<Requisition> arrayList = iRequisitionService.getAllRequisitions();
				for(Requisition list: arrayList){
					if(!list.getStatus().equals("Pending")){
			%>
			<tr>
				<td><%=list.getRequisitionNo()%></td>
				<td><%=list.getRequisitionType()%></td>
				<td><%=list.getItemName()%></td>
				<td><%=list.getItemQty()%></td>
				<td><%=list.getRequestedPrice()%>LKR</td>
				<td><%=list.getTotalPrice()%>LKR</td>
				<td><%=list.getStatus()%></td>

				<td>

					<div class="d-flex gap-3 justify-content-center mt-2 align-self-center">
						<div>
							<form action="DeleteApprovalServlet"method="post">
								<button class="btn btn-danger" type="submit" name="id"  value="<%=list.getRequisitionNo()%>"> Delete
								</button>
							</form>
						</div>
					</div>

				</td>
			</tr>
			<%}}%>
			</tbody>
		</table>
	</div>
</div>

<%--TOAST--%>
<% if (request.getAttribute("Message") != null){ %>
<div class="notification--wrapper hide" id="openToast">
	<div class="notification--reminder ptb--20 text-center col-12">
		<h3 class="toast-title"><%=request.getAttribute("Message")%>
			<a class="exit--toast" href="javascript:void(0);">Got it.</a></h3>
	</div>
</div>
<% } %>

<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
