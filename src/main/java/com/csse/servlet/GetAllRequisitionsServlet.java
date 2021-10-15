package com.csse.servlet;

import com.csse.model.Requisition;
import com.csse.service.IRequisitionService;
import com.csse.service.RequisitionServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetAllRequisitionsServlet", value = "/GetAllRequisitionsServlet")
public class GetAllRequisitionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IRequisitionService iRequisitionService = new RequisitionServiceimpl();
        ArrayList<Requisition> requisitions = iRequisitionService.getAllRequisitions();
        request.setAttribute("requisitions", requisitions);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/RequisitionList.jsp");
        requestDispatcher.forward(request, response);
    }
}
