package com.csse.servlet;

import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteRequisitionServlet", value = "/DeleteRequisitionServlet")
public class DeleteRequisitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int requisitionNo=Integer.parseInt(request.getParameter("id"));
        IRequisitionService requisitionService=new RequisitionServiceimpl();
        requisitionService.removeItem(requisitionNo);
        request.setAttribute("Message","Requisition is Deleted Successfully!");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
        requestDispatcher.forward(request, response);
    }
}
