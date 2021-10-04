<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Supplier</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
<div class="m-5">
    <h1>View Supplier</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Company Name</th>
            <th scope="col">Supplier Name</th>
            <th scope="col">Email</th>
            <th scope="col">Contact Number</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>
                <li><a href="EditSupplierDetails.jsp">Update</a></li>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel1">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>

        <tr>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>Jacob</td>
            <td>
                <li><a href="EditSupplierDetails.jsp">Update</a></li>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
