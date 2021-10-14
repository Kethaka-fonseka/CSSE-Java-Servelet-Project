package com.csse.servlet;


import com.csse.model.Site;
import com.csse.service.SiteService;
import com.csse.service.SiteServiceImpl;
import com.csse.util.CommonConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateSiteServlet", value = "/UpdateSiteServlet")
public class UpdateSiteServlet extends HttpServlet {


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
        Site site = new Site();

        String siteId=request.getParameter("siteId");
        String siteName=request.getParameter("siteName");
        String siteLocation=request.getParameter("siteLocation");
        String siteBudget=request.getParameter("siteBudget");
        String minBudget=request.getParameter("minBudget");

        if (siteName.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_Code);
            RequestDispatcher dis = request.getRequestDispatcher("BudgetList.jsp");
            dis.forward(request, response);

        } else if(siteLocation.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("BudgetList.jsp");
            dis.forward(request, response);
        }
        else if(siteBudget.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_Quantity);
            RequestDispatcher dis = request.getRequestDispatcher("BudgetList.jsp");
            dis.forward(request, response);
        }
        else if(minBudget.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_PRICE);
            RequestDispatcher dis = request.getRequestDispatcher("BudgetList.jsp");
            dis.forward(request, response);
        }else{

            //set data to the variables
            site.setSiteId(siteId);
            site.setSiteName(siteName);
            site.setSiteLocation(siteLocation);
            site.setSiteBudget(Integer.parseInt(siteBudget));
            site.setMinBudget(Integer.parseInt(minBudget));

            SiteService siteService = new SiteServiceImpl();

            if(siteService.updateSite(site)){
                response.sendRedirect("http://localhost:8081/BCConstruction/BudgetList.jsp");
            }

        }




    }
}
