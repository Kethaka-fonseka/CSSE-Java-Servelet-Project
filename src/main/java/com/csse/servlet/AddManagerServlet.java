package com.csse.servlet;

import com.csse.model.Manager;
import com.csse.service.IManagerService;
import com.csse.service.ManagerServiceImpl;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddManagerServlet", value = "/AddManagerServlet")
public class AddManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Manager manager = new Manager();

        manager.setUserRole("manager");
        manager.setUserName(request.getParameter("user_name"));
        manager.setUserMail(request.getParameter("user_email"));
        manager.setUserPass(request.getParameter("pass"));
        manager.setSiteName(request.getParameter("site_name"));
        manager.setMobileNumber(Integer.parseInt(request.getParameter("mob_num")));

        System.out.println(manager.getSiteName());
        IManagerService iManagerService = new ManagerServiceImpl();

        if(!iManagerService.addManager(manager)){
            request.setAttribute("Message","Manager  Added Successfully!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
            requestDispatcher.forward(request, response);

        }else{
            request.setAttribute("Message","Manager Adding Failed!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
