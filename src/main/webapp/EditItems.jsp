<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <form>
        <div class="col-6">
            <label  class="form-label">Company Name</label>
            <input type="text" class="form-control" id="inputCname" placeholder="Company Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Item Name</label>
            <input type="text" class="form-control" id="inputIname" placeholder="Item Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Item Code</label>
            <input type="text" class="form-control" id="inputCode" placeholder="Item Code">
        </div>

        <div class="col-6">
            <label  class="form-label">Quantity</label>
            <input type="number" class="form-control" id="inputQuantity" placeholder="Quantity">
        </div>

        <div class="col-6">
            <label  class="form-label">Price Per One</label>
            <input type="number" class="form-control" id="inputPrice" placeholder="Price Per One">
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
