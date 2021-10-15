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
    <link rel="stylesheet" href="css/forms.css">
    <link rel="stylesheet" href="css/toast.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Head.jsp"/>
<br><br><br>
<div class="container mt-3 rounded-3 text-white"   style="background-color: #333333">
    <h3 class="form-titles text-center pt-4">Add Site Details</h3>
    <form  action="AddSiteServlet" method="post">
        <div class="d-grid gap-3 card-body pt-2 p-5">
        <%
            String message= (String) request.getAttribute("message");


            if(message!=null)  {
        %>
        <%=message%>
        <%
            }
        %>

        <div>
            <label  class="form-label">Site Name</label>
            <input name="siteName" type="text" class="form-control" id="Sname" placeholder="Site Name">
        </div>

        <div>
            <label  class="form-label">Site Location</label>
            <input name="siteLocation" type="text" class="form-control" id="SLocation" placeholder="Site Location">
        </div>

        <div>
            <label  class="form-label">Site Budget</label>
            <input name="siteBudget" type="number" class="form-control" id="SBudget" placeholder="Budget">
        </div>

        <div>
            <label  class="form-label">Site Minimum Budget</label>
            <input name="minBudget" type="number" class="form-control" id="minBudget" placeholder="Minimum Budget">
        </div>



        <div class="text-center">
            <button class="btn btn-light" type="submit">Submit form</button>
        </div>
        </div>
    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
