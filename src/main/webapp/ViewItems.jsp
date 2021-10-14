<%@ page import="com.csse.service.IRegisterService, com.csse.service.RegisterServiceImpl, com.csse.model.User, java.util.ArrayList, com.csse.model.Supplier" %>
<%@ page import="com.csse.service.IItemService" %>
<%@ page import="com.csse.service.ItemServiceImpl" %>
<%@ page import="com.csse.model.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Sandaruwan
  Date: 10/4/2021
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Items</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/toast.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
    <script>

        $(document).ready(function() {
            $("#openToast").toggleClass("hide view");

            $('a.exit--toast').click(function() {
                $("#openToast").fadeOut(1000, 0);
            });

            $(document).on('click', function (e) {
                if ($(e.target).closest(".notification--reminder").length === 0) {
                    $("#openToast").fadeOut(1000, 0);
                }
            });
        });
    </script>
</head>
<body>
<% Supplier sup = (Supplier) session.getAttribute("supplier"); %>
<jsp:include page="Head.jsp"/>
<div  class="card m-5">
    <h4  style="text-transform: uppercase; font-weight: 600" class="text-center  mb-2 pt-3">View Items</h4>


    <div class="m-5" >
        <table class="table ">
            <thead class="text-center">
            <tr>
                <th scope="col">Item ID</th>
                <th scope="col">Item Code</th>
                <th scope="col">Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
                <th scope="col">Actions</th>

            </tr>
            </thead>
            <tbody class="text-center">
            <%
                IItemService iItemService = new ItemServiceImpl();
                List<Item> arrayList = iItemService.getItem();


                for(Item item : arrayList){
                    if (item.getSupplierId() == Integer.parseInt(sup.getSupplierId()))
                    {
            %>
            <tr class="align-content-center">
                <td><%=item.getItemId() %></td>
                <td><%=item.getItemCode() %></td>
                <td><%=item.getItemName()%></td>
                <td><%=item.getQuantity()%></td>
                <td><%=item.getPrice()%></td>
                <td>
                    <div class="d-flex gap-3 justify-content-center">
                        <div>
                            <form method="POST" action="EditItemServlet">
                                <input type="hidden" name="id" value="<%=item.getItemId()%>" />
                                <input type="submit" value="Update" class="btn btn-dark" />
                            </form>
                        </div>

                        <div >
                            <form method="post" action="DeleteItemServlet">
                                <input type="hidden" name="id" value="<%=item.getItemId()%>" />
                                <input type="submit" value="Delete" class="btn btn-danger" />
                            </form>
                        </div>
                    </div>
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
                    <%} }%>
            </tbody>
        </table>
    </div>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
<% if (request.getAttribute("Message") != null){ %>
<div class="notification--wrapper hide" id="openToast">
    <div class="notification--reminder ptb--20 text-center col-12">
        <h3 class="toast-title"><%=request.getAttribute("Message")%> <a class="exit--toast"
                                                                        href="javascript:void(0);">Got it.</a></h3>
    </div>
</div>
<% } %>
</body>
</html>
