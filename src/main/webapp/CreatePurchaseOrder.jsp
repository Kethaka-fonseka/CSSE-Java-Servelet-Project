<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Purchase Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5 ">
    <h1>Create New Purchase Order</h1> <br>
    <h1>Company Details</h1>
    <form>
        <div class="col-6">
            <label  class="form-label">Company Name</label>
            <input type="text" class="form-control" id="inputName" placeholder="Company Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Address</label>
            <input type="tex" class="form-control" id="inputAddress" placeholder="Address">
        </div>

        <div class="col-6">
            <label  class="form-label">Contact NO</label>
            <input type="number" class="form-control" id="inputContact" placeholder="Contact No">
        </div>

        <h1>Supplier Details</h1>

        <div class="col-md-6">
            <label  class="form-label">Supplier Name</label>
            <select id="inputSname" class="form-select">
                <option selected>Choose...</option>
                <option>itmes</option>
            </select>
        </div>

        <div class="col-6">
            <label  class="form-label">Address</label>
            <input type="tex" class="form-control" id="inputSAddress" placeholder="Address">
        </div>

        <div class="col-6">
            <label  class="form-label">Contact NO</label>
            <input type="number" class="form-control" id="inputSContact" placeholder="Contact No">
        </div>

        <h1>Item</h1>

        <div class="col-md-6">
            <label  class="form-label">Item</label>
            <select id="inputLocation" class="form-select">
                <option selected>Choose...</option>
                <option>Item</option>
            </select>
        </div>

        <div class="col-6">
            <label  class="form-label">Quntity</label>
            <input type="number" class="form-control" id="inputQT" placeholder="Quntity">
        </div>

        <div class="col-6">
            <label  class="form-label">Amount</label>
            <input type="number" class="form-control" id="inputAmount" placeholder="Amount">
        </div>

        <h1>Order</h1>

        <div class="col-6">
            <label  class="form-label">Reference No</label>
            <input type="number" class="form-control" id="inputREF" placeholder="Reference No">
        </div>

        <div class="col-6">
            <label  class="form-label">Delivery Address</label>
            <input type="tex" class="form-control" id="inputDAddress" placeholder="Delivery Address">
        </div>

        <div class="col-6">
            <label  class="form-label">Deliery Date</label>
            <input type="date" class="form-control" id="inputDate" placeholder="dd/mm/yyyy">
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
