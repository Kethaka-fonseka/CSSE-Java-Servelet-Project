<%@ page import="com.csse.model.Manager, com.csse.service.IItemService, com.csse.service.ItemServiceImpl, com.csse.model.Item, java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BC | Add Requisition</title>
    <link rel="stylesheet" href="css/forms.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Head.jsp"/>
<div class="container mt-3 mb-3 rounded-3 text-white"  style="background-color: #333333">
  <h3  class="form-titles text-center pt-4">Add Requisition</h3>

    <div class="row mt-3">   <div class="col-lg-5">
  <form method="POST" action="AddRequisitionServlet">
      <div class="d-grid gap-3 card-body pt-2 p-5">
   <%--<div class="col-6">
      <label  class="form-label">Requisition No</label>
      <input type="text" class="form-control" id="inputNumber" placeholder="Requisition No">
    </div>--%>

    <div>
      <label for="inputState" class="form-label">Requisition Type</label>
      <select name="requisitionType" id="inputState" class="form-select">
        <option selected>Choose...</option>
        <option value="Purchase">Purchase</option>
        <option value="Material">Material</option>
        <option value="Stock">Stock</option>
          <option value="Brick">Brick</option>
      </select>
    </div>

    <div>

      <label class="form-label">Requisition By</label>

        <% Manager m = (Manager) session.getAttribute("manager"); %>
        <input  type="text" class="form-control"  name="requestedBy"  value="<%=m.getUserName() %>" readonly>

    </div>

    <div>
      <label for="inputState" class="form-label">Site Name</label>
        <input type="text" name="siteLocation" class="form-control" id="InputSite"
               value="<%=m.getSiteName()%>" readonly>
    </div>

    <div>
      <label for="inputState" class="form-label">Item</label>
      <select name="itemName" id="inputItem" class="form-select">>
          <option value="Sand">Sand</option>
          <option value="Stone">Stones</option>
          <option value="Stone">Stones</option>
          <option value="Cement">Cement</option>
      </select>
    </div>

    <div>
      <label  class="form-label">Quantity</label>
      <input type="text" name="itemQty" class="form-control" id="inputQTY" placeholder="Quantity">
    </div>

    <div>
      <label  class="form-label">Required Price Per Qty </label>
      <input type="text" class="form-control"  name="requestedPrice" id="inputRate" placeholder="Requesting price">
    </div>



    <div class="text-center">
      <button type="submit" class="text-center btn btn-light">Add Req</button>
    </div>
      </div>
  </form>
    </div>
    <div class="col-lg-7 ">
        <h5 style="font-weight: 300 !important"  class="text-center pt-4">Item Summary</h5>
    <table class="table text-white">
        <thead class="text-center">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Quantity</th>
            <th scope="col">Per/</th>

        </tr>
        </thead>
        <tbody class="text-center">
        <%
            IItemService iItemService = new ItemServiceImpl();
            List<Item> arrayList = iItemService.getItem();


            for(Item item : arrayList){
        %>
        <tr class="align-content-center">
            <td><%=item.getItemName()%></td>
            <td><%=item.getQuantity()%></td>
            <td><%=item.getPrice()%></td>
                <% }%>
        </tbody>
    </table>
    </div>
</div></div>

<jsp:include page="footer.jsp"/>
</body>
</html>
