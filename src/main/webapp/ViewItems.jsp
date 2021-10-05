<%@ page import="com.csse.model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.csse.service.ItemServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Items</title>
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
            <th scope="col">Item Name</th>
            <th scope="col">Item Code</th>
            <th scope="col">Quantity</th>
            <th scope="col">Price</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Item> item = ItemServiceImpl.getItem();
            for(Item items : item){
        %>
        <tr>
            <td><%=items.getItemName()%></td>
            <td><%=items.getItemCode()%></td>
            <td><%=items.getQuantity()%></td>
            <td><%=items.getPrice()%></td>
            <td>

                <button href="EditItem.jsp" class="btn btn-primary" type="submit">Edit</button>

            </td>
            <td>
                <form method="POST" action="DeleteServlet">
                <button value="<%=items.getItemId()%>" name="deleteID" class="btn btn-primary" type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
