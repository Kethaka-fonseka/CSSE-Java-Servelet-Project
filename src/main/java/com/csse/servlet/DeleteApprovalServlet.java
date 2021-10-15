package com.csse.servlet;

import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteApprovalServlet", value = "/DeleteApprovalServlet")
public class DeleteApprovalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int requisitionNo=Integer.parseInt(request.getParameter("id"));
        IRequisitionService requisitionService=new RequisitionServiceimpl();
        requisitionService.removeItem(requisitionNo);
        request.setAttribute("Message","Requisition is Deleted Successfully!");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ApprovalHistory.jsp");
        requestDispatcher.forward(request, response);
    }
}
