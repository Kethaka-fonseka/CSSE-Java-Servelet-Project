
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="fonts/icons/style.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">

    <style>

    </style>


</head>

<body class="brain">
<div class="site-navbar bg-white py-2">

    <div class="search-wrap">
        <div class="container">
            <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
            <form action="#" method="post">
                <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
            </form>
        </div>
    </div>

    <div class="container">
        <div class="d-flex align-items-center justify-content-between">
            <div class="logo">
                <div class="site-logo">
                    <a href="landPageCusView.jsp" class="js-logo-clone">
                        <img src="images/Auction.png" id="mainLogo" style="width: 450px;height: 100px;"> </a>
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
                                        <li><a href="RequisitionList.jsp">Check Requisition</a></li>
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
                <a href="#" class="icons-btn d-inline-block js-search-open"><span class="icon-search"></span></a>

<%--                <i class="fas fa-user-tie" style ="color:white;"></i>--%>
                <button class="btnmen">Log out</button>


            </div>
        </div>
    </div>
</div>

</body>
</html>
