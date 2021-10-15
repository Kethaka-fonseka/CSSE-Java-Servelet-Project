package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckOutRequisitionServlet", value = "/CheckOutRequisitionServlet")
public class CheckOutRequisitionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        IRequisitionService iRequisitionService = new RequisitionServiceimpl();
        Requisition requisition = iRequisitionService.getRequisitionByID(id);
        request.setAttribute("requisition", requisition);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Checkout.jsp");
        requestDispatcher.forward(request, response);

    }
}
