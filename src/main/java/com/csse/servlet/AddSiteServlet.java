package com.csse.servlet;

import com.csse.model.Item;
import com.csse.model.Site;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
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

@WebServlet("/AddSiteServlet")
public class AddSiteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSiteServlet() {
        super();
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Site site = new Site();

        String site_name=request.getParameter("siteName");
        String site_location=request.getParameter("siteLocation");
        String site_budget=request.getParameter("siteBudget");
        String minimum_budget=request.getParameter("minBudget");

        if (site_name.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_SITE_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteDetails.jsp");
            dis.forward(request, response);

        } else if(site_location.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_SITE_Location);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteDetails.jsp");
            dis.forward(request, response);
        }
        else if(site_budget.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_SITE_Budget);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteDetails.jsp");
            dis.forward(request, response);
        }
        else if(minimum_budget.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_SITE_MINBudget);
            RequestDispatcher dis = request.getRequestDispatcher("AddSiteDetails.jsp");
            dis.forward(request, response);

        }else{
            //set data to the variables
            site.setSiteName(site_name);
            site.setSiteLocation(site_location);
            site.setSiteBudget(Integer.parseInt(site_budget));
            site.setMinBudget(Integer.parseInt(minimum_budget));

            SiteService siteService = new SiteServiceImpl();

            if(siteService.addSite(site))
                response.sendRedirect("http://localhost:8080/BCConstruction/BudgetList.jsp");
        }
    }
}
