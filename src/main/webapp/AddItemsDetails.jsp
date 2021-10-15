<%@ page import="com.csse.model.Supplier" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Items</title>
    <link rel="stylesheet" href="css/forms.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Head.jsp"/>

<div  class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
    <h3 class="form-titles text-center pt-4">Add Items</h3>



    <form action="AddItemServlet" method="post">
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
            <label  class="form-label">Item Name</label>
            <input name="itemName" type="text" class="form-control" id=Iname" placeholder="Item Name">
        </div>

        <div>
            <label  class="form-label">Item Code</label>
            <input name="itemCode" type="text" class="form-control" id="ICode" placeholder="Item Code">
        </div>

        <div>
            <label  class="form-label">Quantity</label>
            <input name="quantity" type="number" class="form-control" id="IQuantity" placeholder="Quantity">
        </div>

        <div>
            <label  class="form-label">Price Per One</label>
            <input name="price" type="number" class="form-control" id="IPrice" placeholder="Price Per One">
        </div>
            <% Supplier sup = (Supplier) session.getAttribute("supplier"); %>
            <input  type="hidden" class="form-control"  name="sup_id" value ="<%=sup.getSupplierId() %>" >



        <div class="text-center">
            <button class="btn btn-light" type="submit">Submit form</button>
        </div>
        </div>
    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
