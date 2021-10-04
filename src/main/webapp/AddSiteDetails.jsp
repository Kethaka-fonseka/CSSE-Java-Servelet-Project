<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddSiteDetails</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5 ">
    <h1>Add Site Details</h1>
    <form>
        <div class="col-6">
            <label  class="form-label">Site ID</label>
            <input type="text" class="form-control" id="inputSid" placeholder="Site ID">
        </div>

        <div class="col-6">
            <label  class="form-label">Site Name</label>
            <input type="text" class="form-control" id="inputSname" placeholder="Site Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Site Address</label>
            <input type="text" class="form-control" id="inputSAddress" placeholder="Site Address">
        </div>

        <div class="col-6">
            <label  class="form-label">Site Contact No</label>
            <input type="text" class="form-control" id="inputSConNo" placeholder="Site Contact No">
        </div>

        <div class="col-6">
            <label  class="form-label">Budget Amount</label>
            <input type="text" class="form-control" id="inputbudget" placeholder="Budget Amount">
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
