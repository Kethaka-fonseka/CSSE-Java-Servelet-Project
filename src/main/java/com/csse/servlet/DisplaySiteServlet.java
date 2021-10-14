package com.csse.servlet;


import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import com.csse.service.SiteService;
import com.csse.service.SiteServiceImpl;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DisplaySiteServlet")
public class DisplaySiteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            SiteService site = new SiteServiceImpl();
            site.getSite();
            RequestDispatcher dis = request.getRequestDispatcher("BudgetList.jsp");
            dis.forward(request, response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
