package com.csse.servlet;

import com.csse.service.IRegisterService;
import com.csse.service.IStaffService;
import com.csse.service.RegisterServiceImpl;
import com.csse.service.StaffServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteStaffServlet", value = "/DeleteStaffServlet")
public class DeleteStaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userID = request.getParameter("user_id");

        IStaffService iStaffService = new StaffServiceImpl();

        if(iStaffService.removeStaff(userID)){
            request.setAttribute("Message","Staff Removed Successfully!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewStaff.jsp");
            requestDispatcher.forward(request, response);

        }else{
            request.setAttribute("Message","There was an Error!");
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewStaff.jsp");
        requestDispatcher.forward(request, response);
    }



}
