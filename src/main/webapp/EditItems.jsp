<%@ page import="com.csse.service.IItemService" %>
<%@ page import="com.csse.service.ItemServiceImpl" %>
<%@ page import="com.csse.model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Items</title>
    <link rel="stylesheet" href="css/forms.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Head.jsp"/>

<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
    <h3 class="form-titles text-center pt-4">Edit Items</h3>


    <form action="UpdateItemServlet" method="post">
        <div class="d-grid gap-3 card-body pt-2 p-5">
        <%
            Item i= (Item) request.getAttribute("item");
        %>


            <input hidden name="itemId" type="text" class="form-control" value="<%=i.getItemId()%>">
        <div>
            <label  class="form-label">Item Code</label>
            <input name="itemCode" type="text" class="form-control" value="<%=i.getItemCode()%>" id="inputCode" placeholder="Item Name">
        </div>

        <div>
            <label  class="form-label">Item Name</label>
            <input name="itemName" type="text" class="form-control" value="<%=i.getItemName()%>" id="inputIname" placeholder="Item Name">
        </div>

        <div>
            <label  class="form-label">Quantity</label>
            <input name="itemQuantity" type="number" class="form-control" value="<%=i.getQuantity()%>" id="inputQuantity" placeholder="Quantity">
        </div>

        <div>
            <label  class="form-label">Price Per One</label>
            <input name="itemPrice" type="number" class="form-control" value="<%=i.getPrice()%>" id="inputPrice" placeholder="Price Per One">
        </div>

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
