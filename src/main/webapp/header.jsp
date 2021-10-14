
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>

    <link href="https://fonts.googleapis.com/css?family=Rubik:400,700" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://kit.fontawesome.com/7db8364a09.js"></script>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">


</head>

<div class="site-navbar bg-white py-2 ">
    <div class="container">
        <div class="d-flex align-items-center justify-content-between">
            <div class="logo">
                <div class="site-logo">
                    <a href="landPageCusView.jsp" class="js-logo-clone">
                        <img src="images/LogoLG.png" id="mainLogo" style="width: 300px;"> </a>
                </div>
            </div>
            <div class="main-nav d-none d-lg-block">
                <nav class="site-navigation text-right text-md-center" role="navigation">
                    <ul class="site-menu js-clone-nav d-none d-lg-block">

                        <li class="has-children">
                            <a href="landPageCusView.jsp">Inventory transactions</a>
                            <ul class="dropdown">

                                <li class="has-children">
                                    <a href="#">Requisition Form</a>
                                    <ul class="dropdown">
                                        <li><a href="AddRequisition.jsp">Add Requisition</a></li>
                                       <form action="GetAllRequisitionsServlet" method="post">
                                        <li><button type="submit">Check Requisition</button></li>
                                       </form>
                                    </ul>
                                </li>

                                <li class="has-children">
                                    <a href="#">Purchase Order</a>
                                    <ul class="dropdown">
                                        <li><a href="CreatePurchaseOrder.jsp">Create Purchase Order</a></li>
                                        <li><a href="PurchaseOrderHistory.jsp">Purchase Order History</a></li>
                                    </ul>
                                </li>

                                <li >
                                    <a href="ViewApprovePurchaseOrder.jsp">Goods Recived Note</a>

                                </li>
                            </ul>
                        </li>

                        <li class="has-children">
                            <a href="landPageCusView.jsp">Approvals</a>
                            <ul class="dropdown">

                                <li>
                                    <a href="ApprovePurchaseOrder.jsp">Approve Purchase Order</a>
                                </li>

                                <li>
                                    <a href="AddSiteDetails.jsp">Add Site Details</a>
                                </li>

                                <li>
                                    <a href="BudgetList.jsp">Budget List</a>

                                </li>
                            </ul>
                        </li>

                        <li class="has-children">
                            <a href="landPageCusView.jsp">Supplies</a>
                            <ul class="dropdown">

                                <li class="has-children">
                                    <a href="#">Supplier Details</a>
                                    <ul class="dropdown">
                                        <li><a href="AddSupplierDetails.jsp">Add Suppliers</a></li>
                                        <li><a href="ViewSupplier.jsp">View Suppliers</a></li>
                                    </ul>
                                </li>


                                <li class="has-children">
                                    <a href="#">Item Details</a>
                                    <ul class="dropdown">
                                        <li><a href="AddItemsDetails.jsp">Add Items</a></li>
                                        <li><a href="ViewItems.jsp">View Items</a></li>
                                    </ul>
                                </li>


                                <li >
                                    <a href="DeliveryAdviceNote.jsp">Delivery Advice Note</a>

                                </li>

                                <li >
                                    <a href="Invoice.jsp">Invoice & Payment</a>

                                </li>
                            </ul>
                        </li>


                    </ul>
                    </ul>
                </nav>
            </div>
            <div class="icons">
                <button class="btnmen">Sign out</button>
            </div>
        </div>
    </div>
</div>


</html>
