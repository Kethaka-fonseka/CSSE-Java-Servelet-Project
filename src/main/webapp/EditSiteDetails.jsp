<%@ page import="com.csse.model.Site" %><%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 7:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Site Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Head.jsp"/>
<br><br><br>
<div class="m-5 ">
    <h1>Edit Site Details</h1>
    <form action="UpdateSiteServlet" method="post">
        <%
            Site s= (Site) request.getAttribute("site");
        %>

        <input hidden name="siteId" type="text" class="form-control" value="<%=s.getSiteId()%>">
        <div class="col-6">
            <label  class="form-label">Site Name</label>
            <input name="siteName" type="text" class="form-control" id="inputSname" value="<%=s.getSiteName()%>" placeholder="Site Name">
        </div>

        <div class="col-6">
            <label  class="form-label">Site Location</label>
            <input name="siteLocation" type="text" class="form-control" id="inputSLocation" value="<%=s.getSiteLocation()%>" placeholder="Site Location">
        </div>

        <div class="col-6">
            <label  class="form-label">Site Budget</label>
            <input name="siteBudget" type="text" class="form-control" id="inputSAddress" value="<%=s.getSiteBudget()%>" placeholder="Site Budget">
        </div>

        <div class="col-6">
            <label  class="form-label">Site Min Budget</label>
            <input name="minBudget" type="text" class="form-control" id="inputSConNo" value="<%=s.getMinBudget()%>" placeholder="Site Min Budget">
        </div>

            <div>
                <button class="btn btn-primary" type="submit">Submit form</button>
            </div>


    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
