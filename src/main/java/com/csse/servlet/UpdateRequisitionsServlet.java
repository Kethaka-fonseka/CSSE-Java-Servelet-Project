package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateRequisitionsServlet", value = "/UpdateRequisitionsServlet")
public class UpdateRequisitionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Requisition requisition = new Requisition();
        requisition.setRequisitionType(request.getParameter("requisitionType"));
        requisition.setItemName(request.getParameter("itemName"));
        requisition.setItemQty(Integer.parseInt(request.getParameter("itemQty")));
        requisition.setRequestedPrice(Float.parseFloat(request.getParameter("requestedPrice")));
        requisition.setRequisitionNo(Integer.parseInt(request.getParameter("req_id")));
        requisition.setTotalPrice(requisition.getRequestedPrice()* requisition.getItemQty());
        String siteName =(request.getParameter("siteLocation"));
        float price = requisition.getRequestedPrice()* requisition.getItemQty();

        System.out.println(requisition);
        IRequisitionService requisitionService=new RequisitionServiceimpl();
        if(requisitionService.checkApprovable(siteName,price)){
            requisition.setStatus("Approved");
            if(requisitionService.updateRequisition(requisition)){
            request.setAttribute("Message","Your Requisition is automatically Approved and Updated!");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
            dispatcher.forward(request, response);
            }else{
                request.setAttribute("Message","Requisition Update failed!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
                dispatcher.forward(request, response);
            }
        }else{
            requisition.setStatus("Pending");
            if(requisitionService.updateRequisition(requisition)) {
                request.setAttribute("Message", "Your Requisition is sent to the Approval and Updated!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
                dispatcher.forward(request, response);
            }else{
                request.setAttribute("Message","Requisition Update failed!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
                dispatcher.forward(request, response);
            }
        }

    }
}
