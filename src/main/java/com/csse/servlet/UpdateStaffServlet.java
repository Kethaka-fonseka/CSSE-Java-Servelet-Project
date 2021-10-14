package com.csse.servlet;

import com.csse.model.Staff;
import com.csse.service.IStaffService;
import com.csse.service.StaffServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateStaffServlet", value = "/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Staff staff = new Staff();

        String userID = request.getParameter("user_id");
        staff.setUserName(request.getParameter("user_name"));
        staff.setUserMail(request.getParameter("user_email"));
        staff.setUserPass(request.getParameter("pass"));
        staff.setPosition(request.getParameter("staff_role"));
        staff.setMobileNumber(Integer.parseInt(request.getParameter("mob_num")));

        IStaffService iStaffService = new StaffServiceImpl();

        if(iStaffService.updateStaff(userID, staff)){
            request.setAttribute("Message","Staff updated Successfully!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewStaff.jsp");
            requestDispatcher.forward(request, response);

        }else{
            request.setAttribute("Message","There was an error while updating!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewStaff.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
