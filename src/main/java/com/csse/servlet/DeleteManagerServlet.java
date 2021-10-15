package com.csse.servlet;

import com.csse.service.IManagerService;
import com.csse.service.IStaffService;
import com.csse.service.ManagerServiceImpl;
import com.csse.service.StaffServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteManagerServlet", value = "/DeleteManagerServlet")
public class DeleteManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            response.setContentType("text/html");
            String userID = request.getParameter("user_id");

            IManagerService iManagerService = new ManagerServiceImpl();

            if(iManagerService.removeManager(userID)){
                request.setAttribute("Message","Manager Removed Successfully!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
                requestDispatcher.forward(request, response);

            }else{
                request.setAttribute("Message","There was an Error!");
            }
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
