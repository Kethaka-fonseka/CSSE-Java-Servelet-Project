<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Approve Purchase Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5 ">

    <h1>View Approve Purchase Order</h1> <br>
    <h1>Company Details</h1>
    <form>
        <div class="row-6">
            <label  class="form-label">Company Name</label>
            <span class="m-5">BC Construction</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Address</label>
            <span class="m-5">SLIIT,New Kandy Road, Malabe</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Contact NO</label>
            <span class="m-5">0766567654</span>
        </div>

        <h1>Supplier Details</h1>

        <div class="col-md-6">
            <label  class="form-label">Supplier Name</label>
            <span class="m-5">Mandara</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Address</label>
            <span class="m-5">90, New Kandy Road, Malabe</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Contact NO</label>
            <span class="m-5">0766543456</span>
        </div>

        <h1>Item</h1>

        <div class="col-md-6">
            <label  class="form-label">Item</label>
            <span class="m-5">Bricks</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Quntity</label>
            <span class="m-5">10000</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Amount</label>
            <span class="m-5">134400</span>
        </div>

        <h1>Order</h1>

        <div class="col-6">
            <label  class="form-label">Reference No</label>
            <span class="m-5">12345</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Delivery Address</label>
            <span class="m-5">34, New Kandy Road, Malabe</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Deliery Date</label>
            <span class="m-5">12/03/2021</span>
        </div>

        <br>
        <br>
        <div class="col-6">
            <label  class="form-label">Status</label>
            <span class="m-5">Approved</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Status Of Approval</label>
            <span class="m-5">Partial</span>
        </div>

        <div class="col-6">
            <label  class="form-label">Approve Amount</label>
            <span class="m-5">500000</span>
        </div>
        <br>



        <div class="col-12">
            <button class="btn btn-primary" type="submit">Submit form</button>
        </div>

    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
