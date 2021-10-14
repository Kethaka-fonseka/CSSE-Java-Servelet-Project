package com.csse.servlet;

import com.csse.model.Item;
import com.csse.model.Site;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import com.csse.service.SiteService;
import com.csse.service.SiteServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteSiteServlet")
public class DeleteSiteServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        Site site = new Site();
        site.setSiteId(request.getParameter("id"));
        System.out.println(site.getSiteId());

        SiteService siteService = new SiteServiceImpl();
        siteService.deleteSite(site);
        System.out.println(site.getSiteId());


        request.setAttribute("site", site);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/BudgetList.jsp");
        dispatcher.forward(request, response);

    }


}
