<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.csse.model.Requisition"%>
<%@page import="java.util.ArrayList, com.csse.service.IRequisitionService, com.csse.service.RequisitionServiceimpl, com.csse.model.Manager" %>

<html>
<head>
    <title>Requisition List</title>
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
<% Manager m = (Manager) session.getAttribute("manager"); %>
<div class="card m-5">

  <br><br><br>
  <h4 style="text-transform: uppercase; font-weight: 600" class="form-titles  text-center mb-2 pt-3">Requisition List</h4>
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
          if(list.getSiteLocation().equals(m.getSiteName())){
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

        <div class="d-flex gap-3 justify-content-center">
			<% if(list.getStatus().equals("Pending")) {%>
          <div>
            <form action="GetRequisitionByIDServlet" method="post">
                <button class="btn btn-success" name="id" type="submit" value="<%=list.getRequisitionNo()%>" >Update</button>
            </form>
          </div>
			<%} %>
			<% if(list.getStatus().equals("Approved")) {%>
			<div>
            <form action="CheckOutRequsitionServlet" method="post">
                <button class="btn btn-light" name="id" type="submit" >Check Out</button>
            </form>
          </div> <%} %>

          <div>
            <form action="DeleteRequisitionServlet"method="post">
              <button class="btn btn-danger" type="submit" name="id"  value="<%=list.getRequisitionNo()%>" >Delete
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
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>

<% if (request.getAttribute("Message") != null){ %>
<div class="notification--wrapper hide" id="openToast">
    <div class="notification--reminder ptb--20 text-center col-12">
        <h3 class="toast-title"><%=request.getAttribute("Message")%> <a class="exit--toast"
                                                                        href="javascript:void(0);">Got it.</a></h3>
    </div>
</div>
<% } %>

</body>
</html>
