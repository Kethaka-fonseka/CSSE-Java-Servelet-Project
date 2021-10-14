package com.csse.servlet;


import com.csse.model.Item;
import com.csse.model.Site;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import com.csse.service.SiteService;
import com.csse.service.SiteServiceImpl;
import com.csse.util.CommonConstants;
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

@WebServlet(name = "EditSiteServlet", value = "/EditSiteServlet")
public class EditSiteServlet extends HttpServlet {

    public EditSiteServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        //set data to the variables
        String Id = request.getParameter("id");

        try {
            SiteService siteService = new SiteServiceImpl();
            Site site= siteService.editSite(Id);

            request.setAttribute("site",site);
            RequestDispatcher dis = request.getRequestDispatcher("EditSiteDetails.jsp");
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


}
