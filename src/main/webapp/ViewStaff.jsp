<%@ page import="com.csse.service.IRegisterService, com.csse.service.RegisterServiceImpl, com.csse.model.User, java.util.ArrayList, com.csse.model.Supplier, com.csse.service.IStaffService, com.csse.service.StaffServiceImpl, com.csse.model.Staff" %><%--
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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/forms.css">
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

<jsp:include page="Head.jsp"/>

<div  class="card m-5">
<h4  style="text-transform: uppercase; font-weight: 600" class="form-titles  text-center mb-2 pt-3">View Suppliers</h4>

<div class="m-2" >
    <table class="table table-dark table-hover">
        <thead class="text-center">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">User Name</th>
            <th scope="col">Email</th>
            <th scope="col">Position</th>
            <th scope="col">Mobile Number</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody class="align-middle text-center">
        <%
            IStaffService iStaffService = new StaffServiceImpl();
            ArrayList<Staff> arrayList = iStaffService.getStaff();
            for(Staff staff : arrayList){
        %>
        <tr class="align-content-center">
            <td><%=staff.getStaffId() %></td>
            <td><%=staff.getUserName() %></td>
            <td><%=staff.getUserMail() %></td>
            <td><%=staff.getPosition()%></td>
            <td><%=staff.getMobileNumber()%></td>
            <td>
                <div class="d-flex gap-3 justify-content-center">
                <div>
                    <form method="POST" action="GetStaffMemberServlet">
                        <input type="hidden" name="user_id" value="<%=staff.getUserId()%>" />
                        <input type="submit" value="Update" class="btn btn-success" />
                    </form>
                </div>

                <div >
                    <form method="POST" action="DeleteStaffServlet">
                        <input type="hidden" name="user_id" value="<%=staff.getUserId()%>" />
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
                <% }%>
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
