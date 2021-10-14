<%@ page import="com.csse.service.IItemService" %>
<%@ page import="com.csse.service.ItemServiceImpl" %>
<%@ page import="com.csse.model.Item" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Head.jsp"/>
<br><br><br>
<div class="m-5 ">
    <h1>Edit Items</h1>


    <form action="UpdateItemServlet" method="post">
        <%
            Item i= (Item) request.getAttribute("item");
        %>


            <input hidden name="itemId" type="text" class="form-control" value="<%=i.getItemId()%>">
        <div class="col-6">
            <label  class="form-label">Item Code</label>
            <input name="itemCode" type="text" class="form-control" value="<%=i.getItemCode()%>" id="inputCode" placeholder="Item Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Item Name</label>
            <input name="itemName" type="text" class="form-control" value="<%=i.getItemName()%>" id="inputIname" placeholder="Item Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Quantity</label>
            <input name="itemQuantity" type="number" class="form-control" value="<%=i.getQuantity()%>" id="inputQuantity" placeholder="Quantity">
        </div>

        <div class="col-6">
            <label  class="form-label">Price Per One</label>
            <input name="itemPrice" type="number" class="form-control" value="<%=i.getPrice()%>" id="inputPrice" placeholder="Price Per One">
        </div>

        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit form</button>
        </div>

    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
