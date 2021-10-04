<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Supplier Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5 ">
    <h1>Edit Supplier Details</h1>
    <form>
        <div class="col-6">
            <label  class="form-label">Company Name</label>
            <input type="text" class="form-control" id="inputCname" placeholder="Company Name">
        </div>


        <div class="col-6">
            <label  class="form-label">Supplier Name</label>
            <input type="text" class="form-control" id="inputSname" placeholder="Supplier Name">
        </div>


        <div class="col-6">
            <label  class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
        </div>

        <div class="col-6">
            <label  class="form-label">Contact Number</label>
            <input type="text" class="form-control" id="inputConNum" placeholder="Contact Number">
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
