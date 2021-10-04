<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div>
    <h1>Delivery Note</h1>
    <br>

    <div>
        <div class="row">
            <div class="col">
                <h2>Customer Details</h2>
                <div class="row">
                    <div class="col">
                        <label  class="row m-1">Name</label>
                        <label  class="row m-1">Email</label>
                        <label  class="row m-1">Address</label>
                        <label  class="row m-1">Order</label>
                        <label  class="row m-1">Delivery Date</label>
                    </div>
                    <div class="col">
                        <span class="row m-1">Nuwan Perera</span>
                        <span class="row m-1">NuwanPerera@gamil.com</span>
                        <span class="row m-1">malabe</span>
                        <span class="row m-1">100</span>
                        <span class="row m-1">12/03/2021</span>
                    </div>
                </div>
            </div>
            <div class="col">
                <h2>Supplier Details</h2>
                <div class="row">
                    <div class="col">
                        <label  class="row m-1">Name</label>
                        <label  class="row m-1">Email</label>
                        <label  class="row m-1">Address</label>
                        <label  class="row m-1">Order</label>
                        <label  class="row m-1">Delivery Date</label>
                    </div>
                    <div class="col">
                        <span class="row m-1">Nuwan Perera</span>
                        <span class="row m-1">NuwanPerera@gamil.com</span>
                        <span class="row m-1">malabe</span>
                        <span class="row m-1">100</span>
                        <span class="row m-1">12/03/2021</span>
                    </div>
                </div>
            </div>
        </div>

        <br>

        <div class="row">
            <div class="col">
                <h2>Item Name</h2>
                <div class="row">
                    <span class="row m-1">Cement Holcim</span>
                    <span class="row m-1">Iron Pillar</span>
                    <span class="row m-1">Concrete Pillars</span>
                </div>

            </div>
            <div class="col">
                <h2>Quantity</h2>
                <div class="row">
                    <span class="row m-1">100</span>
                    <span class="row m-1">500</span>
                    <span class="row m-1">250</span>
                </div>
            </div>
            <div class="col">
                <h2>Unit Price</h2>
                <div class="row">
                    <span class="row m-1">100</span>
                    <span class="row m-1">500</span>
                    <span class="row m-1">250</span>
                </div>
            </div>
            <div class="col">
                <h2>Total</h2>
                <div class="row">
                    <span class="row m-1">100</span>
                    <span class="row m-1">500</span>
                    <span class="row m-1">250</span>
                </div>
            </div>
        </div>

        <br>
        <br>
        <div class="row">
            <div class="col">
                <div class="row">
                    <h5>-----------------</h5>
                    <h5>Supplier Signature</h5>
                </div>

            </div>
            <div class="col">
                <div class="row">
                    <h5>-----------------</h5>
                    <h5>Customer Signature</h5>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
