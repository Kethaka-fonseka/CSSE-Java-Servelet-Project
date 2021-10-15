package com.csse.servlet;

import com.csse.model.Manager;
import com.csse.service.IManagerService;
import com.csse.service.ManagerServiceImpl;
import com.csse.util.CommonConstants;


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
        String user_name = request.getParameter("user_name");
        String user_email = request.getParameter("user_email");
        String pass = request.getParameter("pass");
        String site_name = request.getParameter("site_name");
        String contact = request.getParameter("mob_num");
        String userID = request.getParameter("user_id");


        if (user_name.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("UpdateManager.jsp");
            dis.forward(request, response);

        } else if (user_email.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_EMAIL);
            RequestDispatcher dis = request.getRequestDispatcher("UpdateManager.jsp");
            dis.forward(request, response);
        } else if (pass.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_PASSWORD);
            RequestDispatcher dis = request.getRequestDispatcher("UpdateManager.jsp");
            dis.forward(request, response);
        } else if (site_name.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_SITENAME);
            RequestDispatcher dis = request.getRequestDispatcher("UpdateManager.jsp");
            dis.forward(request, response);

        } else if (contact.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_MANAGER_MOBILE);
            RequestDispatcher dis = request.getRequestDispatcher("UpdateManager.jsp");
            dis.forward(request, response);

        } else {

            manager.setUserName(user_name);
            manager.setUserMail(user_email);
            manager.setUserPass(pass);
            manager.setSiteName(site_name);
            manager.setMobileNumber(Integer.parseInt(contact));

            IManagerService iManagerService = new ManagerServiceImpl();

            if (iManagerService.updateManager(userID, manager)) {
                request.setAttribute("Message", "Manager updated Successfully!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
                requestDispatcher.forward(request, response);

            } else {
                request.setAttribute("Message", "There was an error while updating!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewManagers.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
