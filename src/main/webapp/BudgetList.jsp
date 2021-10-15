<%@ page import="com.csse.model.Site" %>
<%@ page import="java.util.List" %>
<%@ page import="com.csse.service.SiteServiceImpl" %>
<%@ page import="com.csse.service.SiteService" %><%--
  Created by IntelliJ IDEA.
  User: Ushan
  Date: 10/4/2021
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Budget List</title>
    <link rel="stylesheet" href="css/forms.css">
    <link rel="stylesheet" href="css/toast.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Head.jsp"/>

<div class="card m-5 ">
    <h4  style="text-transform: uppercase; font-weight: 600" class="form-titles  text-center mb-2 pt-3">Budget List</h4>
    <div class="m-2">
    <table class="table table-dark table-hover">
        <thead class="text-center">
        <tr>
            <th scope="col">Site Name</th>
            <th scope="col">Site Address</th>
            <th scope="col">Site Contract No</th>
            <th scope="col">Budget Amount</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody class="align-middle text-center">
        <%
            SiteService siteService = new SiteServiceImpl();
            List<Site> arrayList = siteService.getSite();


            for(Site site : arrayList){
        %>
        <tr>

            <td><%=site.getSiteName()%></td>
            <td><%=site.getSiteLocation()%></td>
            <td><%=site.getSiteBudget()%></td>
            <td><%=site.getMinBudget()%></td>
            <td>
                <div class="d-flex gap-3 justify-content-center">
                    <div>
                        <form method="POST" action="EditSiteServlet">
                            <input type="hidden" name="id" value="<%=site.getSiteId()%>" />
                            <input type="submit" value="Update" class="btn btn-success" />
                        </form>
                    </div>

                    <div >
                        <form method="post" action="DeleteSiteServlet">
                            <input type="hidden" name="id" value="<%=site.getSiteId()%>" />
                            <input type="submit" value="Delete" class="btn btn-danger" />
                        </form>
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
</body>
</html>
