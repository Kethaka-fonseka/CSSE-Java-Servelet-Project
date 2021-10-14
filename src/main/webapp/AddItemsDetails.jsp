<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"/>
<br><br><br>
<div class="m-5 ">
    <h1>Add Items</h1>



    <form action="AddItemServlet" method="post">
        <%
            String message= (String) request.getAttribute("message");


            if(message!=null)  {
        %>
        <%=message%>
        <%
        }
        %>


        <div class="col-6">
            <label  class="form-label">Item Name</label>
            <input name="itemName" type="text" class="form-control" id=Iname" placeholder="Item Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Item Code</label>
            <input name="itemCode" type="text" class="form-control" id="ICode" placeholder="Item Code">
        </div>

        <div class="col-6">
            <label  class="form-label">Quantity</label>
            <input name="quantity" type="number" class="form-control" id="IQuantity" placeholder="Quantity">
        </div>

        <div class="col-6">
            <label  class="form-label">Price Per One</label>
            <input name="price" type="number" class="form-control" id="IPrice" placeholder="Price Per One">
        </div>


        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit form</button>
        </div>

    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
