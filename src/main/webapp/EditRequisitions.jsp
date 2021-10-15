<%@ page import="com.csse.model.Manager, com.csse.model.Requisition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Requisition Details</title>
</head>
<body>
<jsp:include page="Head.jsp"/>
<div class="container mt-3 rounded-3 text-white"  style="background-color: #333333">
    <h3 class="form-titles text-center pt-4">Update Requisitions</h3>
    <% Requisition requisition = (Requisition) request.getAttribute("requisition"); %>
    <form method="POST" action="UpdateRequisitionsServlet">
        <div class="d-grid gap-3 card-body pt-2 p-5">

            <div>
                <label for="inputState" class="form-label">Requisition Type</label>
                <select name="requisitionType" id="inputState" class="form-select">
                    <option value="<%=requisition.getRequisitionType()%>" selected><%=requisition.getRequisitionType()%></option>
                    <option value="Purchase">Purchase</option>
                    <option value="Material">Material</option>
                    <option value="Stock">Stock</option>
                    <option value="Brick">Brick</option>
                </select>
            </div>

            <div>
                <label class="form-label">Requisition By</label>
                <input  type="text" class="form-control"  name="requestedBy" value="<%=requisition.getRequestedBy()%>"
                        readonly>

            </div>

            <div>
                <label for="inputState" class="form-label">Site Name</label>
                <input type="text" name="siteLocation" class="form-control" id="InputSite"
                   value="<%=requisition.getSiteLocation()%>" readonly>
            </div>

            <div>
                <label for="inputState" class="form-label">Item</label>
                <select name="itemName" id="inputItem" class="form-select">>

                    <option value="<%=requisition.getItemName()%>" selected><%=requisition.getItemName()%></option>
                    <option value="Sand" >Sand</option>
                    <option value="Stone">Stones</option>
                    <option value="Stone">Stones</option>
                    <option value="Cement">Cement</option>
                </select>
            </div>

            <div>
                <label  class="form-label">Quantity</label>
                <input type="number" name="itemQty" value="<%=requisition.getItemQty()%>" class="form-control" id="inputQTY"
                       placeholder="Quantity">
            </div>

            <div><input type="hidden" name="req_id" value="<%=requisition.getRequisitionNo()%>" class="form-control">
            </div>

            <div>
                <label  class="form-label">Required Price Per Qty </label>
                <input type="number" class="form-control" value="<%=requisition.getRequestedPrice()%>" name="requestedPrice"
                       id="inputRate"
                       placeholder="Requesting price">
            </div>


            <div>
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
                <button type="submit" class="text-center btn btn-light">Update</button>
            </div>
        </div>
    </form>
</div>
<!-- FOOTER -->
<jsp:include page="footer.jsp"/>
</body>
</html>
