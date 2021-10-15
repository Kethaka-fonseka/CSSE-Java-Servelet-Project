package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ApproveServlet", value = "/ApproveServlet")
public class ApproveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Requisition requisition = new Requisition();
        requisition.setRequisitionNo(Integer.parseInt(request.getParameter("id")));
        String status = request.getParameter("state");

        IRequisitionService iRequisitionService = new RequisitionServiceimpl();
        if(status.equals("Approve")){
            requisition.setStatus("Approved");
            if(iRequisitionService.approvalRequisition(requisition)){
                request.setAttribute("Message","That requisition is approved!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ApprovalHistory.jsp");
                dispatcher.forward(request, response);
            }
            else{
                request.setAttribute("Message","Requisition Update failed!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Approval.jsp");
                dispatcher.forward(request, response);

            }
        }

        if(status.equals("Decline")){
            requisition.setStatus("Decline");
            if(iRequisitionService.approvalRequisition(requisition)){
                request.setAttribute("Message","That requisition is Declined!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ApprovalHistory.jsp");
                dispatcher.forward(request, response);
            }
            else{
                request.setAttribute("Message","Requisition Update failed!");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Approval.jsp");
                dispatcher.forward(request, response);

            }
        }
    }
}
