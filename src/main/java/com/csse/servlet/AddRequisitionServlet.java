package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;
import com.csse.util.CommonConstants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRequisitionServlet", value = "/AddRequisitionServlet")
public class AddRequisitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Requisition requisition = new Requisition();

        String requisitionType= request.getParameter("requisitionType");
        String requestedBy= request.getParameter("requestedBy");
        String siteLocation= request.getParameter("siteLocation");
        String itemName= request.getParameter("itemName");
        String itemQty= request.getParameter("itemQty");
        String requestedPrice= request.getParameter("requestedPrice");


        if (requisitionType.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_REQUISITION_TYPE);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        } else if (requestedBy.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_REQUISITION_REQUESTEDBY);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);
        } else if (siteLocation.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_REQUISITION_SITE_LOCATION);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);
        } else if (itemName.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_REQUISITION_ITEM_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        } else if (itemQty.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_REQUISITION_ITEM_QTY);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        } else if (requestedPrice.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_REQUISITION_REQUESTED_PRICE);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        }else {

            requisition.setRequisitionType(requisitionType);
            requisition.setRequestedBy(requestedBy);
            requisition.setSiteLocation(siteLocation);
            requisition.setItemName(itemName);
            requisition.setItemQty(Integer.parseInt(itemQty));
            requisition.setRequestedPrice(Float.parseFloat(requestedPrice));
            requisition.setTotalPrice(requisition.getRequestedPrice() * requisition.getItemQty());
            String siteName = (request.getParameter("siteLocation"));
            float price = requisition.getRequestedPrice() * requisition.getItemQty();

            System.out.println(requisition);
            IRequisitionService requisitionService = new RequisitionServiceimpl();
            if (requisitionService.checkApprovable(siteName, price)) {
                requisition.setStatus("Approved");
                requisitionService.addRequisition(requisition);
                request.setAttribute("Message", "Your Requisition is automatically Approved!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
                dispatcher.forward(request, response);
            } else {
                requisition.setStatus("Pending");
                requisitionService.addRequisition(requisition);
                request.setAttribute("Message", "Your Requisition is sent to the Approval!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
                dispatcher.forward(request, response);
            }

        }
    }
}
