package com.csse.servlet;

import com.csse.model.Manager;
import com.csse.service.IManagerService;
import com.csse.service.ManagerServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateManagerServlet", value = "/UpdateManagerServlet")
public class UpdateManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Manager manager = new Manager();

        String userID = request.getParameter("user_id");
        manager.setUserName(request.getParameter("user_name"));
        manager.setUserMail(request.getParameter("user_email"));
        manager.setUserPass(request.getParameter("pass"));
        manager.setSiteName(request.getParameter("site_name"));
        manager.setMobileNumber(Integer.parseInt(request.getParameter("mob_num")));

        IManagerService iManagerService = new ManagerServiceImpl();

        if(iManagerService.updateManager(userID, manager)){
            request.setAttribute("Message","Manager updated Successfully!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
            requestDispatcher.forward(request, response);

        }else{
            request.setAttribute("Message","There was an error while updating!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
