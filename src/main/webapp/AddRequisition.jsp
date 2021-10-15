<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Requisition</title>
    <link rel="stylesheet" href="css/forms.css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

</head>
<body>
<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
  <h3  class="form-titles text-center pt-4">Add Requisition</h3>
  <form method="POST" action="AddRequisionServlet">
      <div class="d-grid gap-3 card-body pt-2 p-5">
   <%--<div class="col-6">
      <label  class="form-label">Requisition No</label>
      <input type="text" class="form-control" id="inputNumber" placeholder="Requisition No">
    </div>--%>

    <div>
      <label for="inputState" class="form-label">Requisition Type</label>
      <select name="requisitionType" id="inputState" class="form-select">
        <option selected>Choose...</option>
        <option value="type1">type1</option>
        <option value="type2">type2</option>
        <option value="type3">type3</option>
      </select>
    </div>

    <div>
      <label  class="form-label">Requisition By</label>
      <input type="text" name="requestedBy" class="form-control" id="inputReqBy" placeholder="Requisition By">
    </div>

    <div>
      <label for="inputState" class="form-label">Site Location</label>
      <select name="siteLocation" id="inputLocation" class="form-select">
        <option value="colombo">Colombo</option>
      </select>
    </div>

    <div>
      <label for="inputState" class="form-label">Item</label>
      <select name="itemName" id="inputItem" class="form-select">>
        <option value="sand">Sand</option>
        <option value="stone">Stones</option>
        <option value="cement">Cement</option>
      </select>
    </div>

    <div>
      <label  class="form-label">Quantity</label>
      <input type="text" name="itemQty" class="form-control" id="inputQTY" placeholder="Quantity">
    </div>

    <div>
      <label  class="form-label">Requesting Price</label>
      <input type="text" class="form-control"  name="requestedPrice" id="inputRate" placeholder="Requesting price">
    </div>


    <div>
      <label  class="form-label">Action</label>
      <div class="form-check">
        <input class="form-check-input " type="checkbox" value="" id="invalidCheck3" aria-describedby="invalidCheck3Feedback" >
        <label class="form-check-label" for="invalidCheck3">
          Send To Approval
        </label>
        <div id="invalidCheck3Feedback" class="invalid-feedback text-white">
          You must agree before submitting.
        </div>
      </div>
    </div>

    <div class="text-center">
      <button class="btn btn-light" type="submit">Submit form</button>
    </div>
      </div>
  </form>
</div>

</body>
</html>
