package com.csse.servlet;

import com.csse.model.Manager;
import com.csse.model.Staff;
import com.csse.service.IManagerService;
import com.csse.service.IStaffService;
import com.csse.service.ManagerServiceImpl;
import com.csse.service.StaffServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetManagerServlet", value = "/GetManagerServlet")
public class GetManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String userID = request.getParameter("user_id");
        IManagerService iManagerService =  new ManagerServiceImpl();
        Manager manager = iManagerService.getManagerByID(userID);
        request.setAttribute("manager", manager);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/UpdateManager.jsp");
        requestDispatcher.forward(request, response);
    }
}
