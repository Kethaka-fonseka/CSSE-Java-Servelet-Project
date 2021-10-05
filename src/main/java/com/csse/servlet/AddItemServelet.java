package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * Servlet implementation AddItem
 */
@WebServlet("/AddItemServlet")
public class AddItemServelet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServelet() {
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

        response.setContentType("text/html");

        Item item = new Item();

        //set data to the variables
        item.setCompanyName(request.getParameter("companyName"));
        item.setItemName(request.getParameter("itemName"));
        item.setItemCode(request.getParameter("itemCode"));
        item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        item.setPrice(Double.parseDouble(request.getParameter("price")));

        IItemService iItemService = new ItemServiceImpl();
        iItemService.addItem(item);

        //set attribute
        request.setAttribute("item", item);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewItems.jsp");
        dispatcher.forward(request, response);
    }
}
