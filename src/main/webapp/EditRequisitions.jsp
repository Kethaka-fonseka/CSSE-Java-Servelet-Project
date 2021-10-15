
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Requisition Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
    <h3 class="form-titles text-center pt-4">Add Supplier Details</h3>
    <form>
        <div class="d-grid gap-3 card-body pt-2 p-5">
        <div >
            <label  class="form-label">Company Name</label>
            <input type="text" class="form-control" id="inputCname" placeholder="Company Name">
        </div>


        <div >
            <label  class="form-label">Supplier Name</label>
            <input type="text" class="form-control" id="inputSname" placeholder="Supplier Name">
        </div>


        <div c>
            <label  class="form-label">Email</label>
            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
        </div>

        <div >
            <label  class="form-label">Contact Number</label>
            <input type="text" class="form-control" id="inputConNum" placeholder="Contact Number">
        </div>


        <div class="text-center">
            <button class="btn btn-light" type="submit">Submit form</button>
        </div>
        </div>
    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
