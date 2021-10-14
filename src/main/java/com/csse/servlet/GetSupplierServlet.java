package com.csse.servlet;

import com.csse.model.Supplier;
import com.csse.service.IRegisterService;
import com.csse.service.RegisterServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetSupplierServlet", value = "/GetSupplierServlet")
public class GetSupplierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String userID = request.getParameter("user_id");
        IRegisterService iRegisterService = new RegisterServiceImpl();
        Supplier supplier = iRegisterService.getSupplierByID(userID);
        request.setAttribute("supplier", supplier);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UpdateSupplier.jsp");
        requestDispatcher.forward(request, response);

    }
}
