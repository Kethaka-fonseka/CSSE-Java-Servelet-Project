
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="fonts/icons/style.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">

    <title>Add Supplier Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="card m-5"  style="background-color: #ececec">
    <h4  style="text-transform: uppercase; font-weight: 600" class="text-center  pt-3">Add Suppliers</h4>
    <form method="POST" action="AddUserServlet">
 <div class="d-grid gap-2 card-body pt-2 p-5">
     <div >
            <label  class="form-label">User Name</label>
            <input type="text" class="form-control" name="user_name"  id="inputName" placeholder="User Name">
        </div>


        <div >
            <label  class="form-label">Email</label>
            <input type="email" class="form-control" name="email" id="inputEmail" placeholder="example@gmail.com">
        </div>

        <div >
            <label  class="form-label">Password</label>
            <input type="password" class="form-control" name="pass" id="inputPass" >
        </div>

        <div >
            <label  class="form-label">Company Name</label>
            <input type="text" class="form-control" id="inputCopmany" name="company_name" placeholder="JMIS Hardware">
        </div>

       <div>
            <label  class="form-label">Mobile Number</label>
            <input type="number" class="form-control" id="inputNumber" name="mob_num" placeholder="0774322123">
        </div>

     <div class="form-group text-center p-4" style="color: red; text-transform: uppercase">
         <%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%>
     </div>

        <div class="text-center mt-4">
            <button class="btn btn-dark col-2 " type="submit">Add User</button>
        </div>


 </div>
    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
