<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Requisition</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5 ">
    <h1>Edit Requisition</h1>
    <form>
        <div class="col-6">
            <label  class="form-label">Requisition No</label>
            <input type="text" class="form-control" id="inputNumber" placeholder="Requisition No">
        </div>

        <div class="col-md-6">
            <label for="inputState" class="form-label">Requisition Type</label>
            <select id="inputState" class="form-select">
                <option selected>Choose...</option>
                <option>itmes</option>
            </select>
        </div>

        <div class="col-6">
            <label  class="form-label">Requisition By</label>
            <input type="text" class="form-control" id="inputReqBy" placeholder="Requisition By">
        </div>

        <div class="col-md-6">
            <label for="inputState" class="form-label">Site Location</label>
            <select id="inputLocation" class="form-select">
                <option selected>Choose...</option>
                <option>Colombo</option>
            </select>
        </div>

        <div class="col-md-6">
            <label for="inputState" class="form-label">Item</label>
            <select id="inputItem" class="form-select">
                <option selected>Choose...</option>
                <option>itmes</option>
            </select>
        </div>

        <div class="col-6">
            <label  class="form-label">Quntity</label>
            <input type="text" class="form-control" id="inputQTY" placeholder="Quntity">
        </div>

        <div class="col-6">
            <label  class="form-label">Rate</label>
            <input type="text" class="form-control" id="inputRate" placeholder="Rate">
        </div>

        <div class="col-12">
            <label  class="form-label">Action</label>
            <div class="form-check">
                <input class="form-check-input " type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" required>
                <label class="form-check-label" for="invalidCheck3">
                    Send To Approval
                </label>
                <div id="invalidCheck3Feedback" class="invalid-feedback">
                    You must agree before submitting.
                </div>
            </div>
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
