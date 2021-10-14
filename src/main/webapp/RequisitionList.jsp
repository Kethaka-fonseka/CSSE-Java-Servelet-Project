<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.csse.model.Requisition"%>
<%@page import="java.util.ArrayList" %>

<html>
<head>
    <title>Requisition List</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="card m-5">

  <br><br><br>
  <h1 style="text-transform: uppercase; font-weight: 600" class="text-center  pt-3">Requisition List</h1>
  <div class="card m-5">
  <table class="table table-dark table-hover">
    <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Item</th>
      <th scope="col">Quantity</th>
      <th scope="col">Rate</th>
      <th scope="col">Amount</th>
      <th scope="col">Requested By</th>
      <th scope="col">Status</th>
      <th scope="col">Actions</th>

    </tr>
    </thead>
    <tbody class="align-middle">
    <%
      ArrayList<Requisition> requisitions=(ArrayList<Requisition>) request.getAttribute("requisitions");
      for(Requisition list:requisitions){
    %>
    <tr>
    <td><%=list.getRequisitionNo()%></td>
      <td><%=list.getRequisitionType()%></td>
      <td><%=list.getItemQty()%></td>
      <td><%=list.getRequestedPrice()%></td>
      <td><%=list.getTotalPrice()%></td>
      <td><%=list.getRequestedBy()%></td>
      <td><%=list.getStatus()%></td>
      <td>
        <form action="GetRequisitionByIDServlet" method="post">
       <button class="btn btn-success" name="id" type="submit" value=<%=list.getRequisitionNo()%>><i class="fa fa-pencil-square-o"></i></button>
        </form>
        <form action="DeleteRequisitionServlet"method="post">
        <button class="btn btn-danger" type="submit"  name="id" value=<%=list.getRequisitionNo()%> ><i class="fa fa-trash"></i></button>
        </form>

      </td>
    </tr>
<%}%>
    </tbody>
  </table>
  </div>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
