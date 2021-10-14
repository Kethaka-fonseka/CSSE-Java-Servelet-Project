package com.csse.servlet;

import com.csse.model.Staff;
import com.csse.service.IStaffService;
import com.csse.service.StaffServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetStaffMemberServlet", value = "/GetStaffMemberServlet")
public class GetStaffMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String userID = request.getParameter("user_id");
        IStaffService iStaffService =  new StaffServiceImpl();
        Staff staff = iStaffService.getStaffByID(userID);
        request.setAttribute("staff", staff);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UpdateStaff.jsp");
        requestDispatcher.forward(request, response);
    }

}
