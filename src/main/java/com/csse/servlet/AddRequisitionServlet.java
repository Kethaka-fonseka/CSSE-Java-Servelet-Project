package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddRequisionServlet", value = "/AddRequisionServlet")
public class AddRequisitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Requisition requisition = new Requisition();
        requisition.setRequisitionType(request.getParameter("requisitionType"));
        requisition.setRequestedBy(request.getParameter("requestedBy"));
        requisition.setSiteLocation(request.getParameter("siteLocation"));
        requisition.setItemName(request.getParameter("itemName"));
        requisition.setItemQty(Integer.parseInt(request.getParameter("itemQty")));
        requisition.setRequestedPrice(Float.parseFloat(request.getParameter("requestedPrice")));
        requisition.setTotalPrice(requisition.getRequestedPrice()* requisition.getItemQty());

        IRequisitionService requisitionService=new RequisitionServiceimpl();
        requisitionService.addRequisition(requisition);
        System.out.println("req:"+requisition);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/landPageCusView.jsp");
        dispatcher.forward(request, response);

    }
}
