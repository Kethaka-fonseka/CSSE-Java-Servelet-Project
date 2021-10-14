package com.csse.servlet;

import com.csse.model.Supplier;
import com.csse.model.User;
import com.csse.service.IRegisterService;
import com.csse.service.RegisterServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteSupplierServlet", value = "/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userID = request.getParameter("user_id");

        IRegisterService iRegisterService = new RegisterServiceImpl();

        if(iRegisterService.removeSupplier(userID)){
            request.setAttribute("Message","Supplier Removed Successfully!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewSupplier.jsp");
            requestDispatcher.forward(request, response);

        }else{
            request.setAttribute("Message","There was an Error!");
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewSupplier.jsp");
            requestDispatcher.forward(request, response);
        }


}
