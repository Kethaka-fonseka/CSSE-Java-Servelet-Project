package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import com.csse.util.CommonConstants;

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

        Item item = new Item();

        String i_name=request.getParameter("itemName");
        String i_code=request.getParameter("itemCode");
        String i_quantity=request.getParameter("quantity");
        String i_price=request.getParameter("price");

        if (i_name.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("AddItemsDetails.jsp");
            dis.forward(request, response);

        } else if(i_code.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_Code);
            RequestDispatcher dis = request.getRequestDispatcher("AddItemsDetails.jsp");
            dis.forward(request, response);
        }
        else if(i_quantity.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_Quantity);
            RequestDispatcher dis = request.getRequestDispatcher("AddItemsDetails.jsp");
            dis.forward(request, response);
        }
        else if(i_price.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_PRICE);
            RequestDispatcher dis = request.getRequestDispatcher("AddItemsDetails.jsp");
            dis.forward(request, response);

        }else{
            //set data to the variables
            item.setItemName(i_name);
            item.setItemCode(i_code);
            item.setQuantity(Integer.parseInt(i_quantity));
            item.setPrice(Double.parseDouble(i_price));

            IItemService iItemService = new ItemServiceImpl();

            if(iItemService.addItem(item))
                response.sendRedirect("http://localhost:8080/BCConstruction/ViewItems.jsp");
        }
    }
}
