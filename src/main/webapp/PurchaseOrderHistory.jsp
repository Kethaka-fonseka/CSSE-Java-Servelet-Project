<%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 5:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Purchase Order History</title>
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Head.jsp"/>
<br><br><br>
<div class="card m-5">
    <h1 style="text-transform: uppercase; font-weight: 600" class="text-center  mb-2 pt-3">Purchase Order List</h1>
    <div class="card m-5">
    <table class="table table-dark table-hover">
        <thead>
        <tr>
            <th scope="col">Reference ID</th>
            <th scope="col">Supplier</th>
            <th scope="col">Amount</th>
            <th scope="col">Order Date</th>
            <th scope="col">Requested By</th>
            <th scope="col">Status</th>
            <th scope="col">Approved Date</th>
            <th scope="col">Approved Amount</th>
            <th scope="col">Actions</th>

        </tr>
        </thead>
        <tbody class="align-middle">
        <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>@mdo</td>
            <td>
                <div class="d-flex gap-3 ">
                    <div>
<%--                        <form>--%>
<%--                            <input type="submit" value="Update" class="icon btn-success" />--%>
<%--                        </form>--%>
                        <button class="btn btn-success"><i class="fa fa-pencil-square-o"></i></button>
                    </div>

                    <div >
<%--                        <form>--%>
<%--                            <input type="submit" value="Delete" class="btn btn-danger" />--%>
<%--                        </form>--%>
                        <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
                    </div>
                </div>
            </td>

        <tr>
            <th scope="row">2</th>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>Jacob</td>
            <td>Thornton</td>
            <td>@fat</td>
            <td>Jacob</td>
            <td>
                <div class="d-flex gap-3 ">
                    <div>
<%--                        <form>--%>

<%--                            <input type="submit" value="Update" class="btn btn-success" />--%>
<%--                            --%>
<%--                        </form>--%>
                            <button class="btn btn-success"><i class="fa fa-pencil-square-o"></i></button>
                    </div>

                    <div >
<%--                        <form>--%>
<%--                            <input type="submit" value="Delete" class="btn btn-danger" />--%>
<%--                        </form>--%>
                            <button class="btn btn-danger"><i class="fa fa-trash"></i></button>
                    </div>
                </div>
            </td>
        </tr>
        </tbody>
    </table>
    </div>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
