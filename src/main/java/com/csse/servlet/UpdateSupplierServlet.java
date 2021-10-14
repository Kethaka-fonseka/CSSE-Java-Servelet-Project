package com.csse.servlet;

import com.csse.model.Supplier;
import com.csse.model.User;
import com.csse.service.IRegisterService;
import com.csse.service.RegisterServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateSupplierServlet", value = "/UpdateSupplierServlet")
public class UpdateSupplierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Supplier supplier = new Supplier();
        String userID = request.getParameter("user_id");
        supplier.setUserName(request.getParameter("user_name"));
        supplier.setUserMail(request.getParameter("user_email"));
        supplier.setUserPass(request.getParameter("pass"));
        supplier.setCompanyName(request.getParameter("company_name"));
        supplier.setContactNumber(Integer.parseInt(request.getParameter("mob_num")));

        IRegisterService iRegisterService = new RegisterServiceImpl();

        if(iRegisterService.updateSupplier(userID, supplier)){
            request.setAttribute("Message","Supplier Updated Successfully!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewSupplier.jsp");
            requestDispatcher.forward(request, response);

        }else{
            request.setAttribute("Message","There was an Error!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewSupplier.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
