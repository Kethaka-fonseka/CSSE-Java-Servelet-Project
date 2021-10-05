
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5 ">
    <h1>Edit Items</h1>
    <form action="EditItemServlet" method="post">

        <div class="col-6">
            <label  class="form-label">Item Name</label>
            <input name="itemName" type="text" class="form-control" id="inputIname" placeholder="Item Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Quantity</label>
            <input name="quantity" type="number" class="form-control" id="inputQuantity" placeholder="Quantity">
        </div>

        <div class="col-6">
            <label  class="form-label">Price Per One</label>
            <input name="price" type="number" class="form-control" id="inputPrice" placeholder="Price Per One">
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
