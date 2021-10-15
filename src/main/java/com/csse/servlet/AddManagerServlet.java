package com.csse.servlet;

import com.csse.model.Manager;
import com.csse.service.IManagerService;
import com.csse.service.ManagerServiceImpl;
import com.csse.util.CommonConstants;


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

        String user_name = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String password = request.getParameter("pass");
        String site_name = request.getParameter("site_name");
        String mobile = request.getParameter("mob_num");

        if (user_name.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        } else if (email.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_EMAIL);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);
        } else if (password.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_PASSWORD);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);
        } else if (site_name.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_SITENAME);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        } else if (mobile.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_MOBILE);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteManager.jsp");
            dis.forward(request, response);

        } else {

            manager.setUserRole("manager");
            manager.setUserName(user_name);
            manager.setUserMail(email);
            manager.setUserPass(password);
            manager.setSiteName(site_name);
            manager.setMobileNumber(Integer.parseInt(mobile));

            System.out.println(manager.getSiteName());
            IManagerService iManagerService = new ManagerServiceImpl();

            if (!iManagerService.addManager(manager)) {
                request.setAttribute("Message", "Manager  Added Successfully!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
                requestDispatcher.forward(request, response);

            } else {
                request.setAttribute("Message", "Manager Adding Failed!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
