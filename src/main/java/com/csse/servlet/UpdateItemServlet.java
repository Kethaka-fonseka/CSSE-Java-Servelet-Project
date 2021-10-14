package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import com.csse.util.CommonConstants;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateItemServlet", value = "/UpdateItemServlet")
public class UpdateItemServlet extends HttpServlet {
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
        Item item = new Item();

        String itemId=request.getParameter("itemId");
        String itemCode=request.getParameter("itemCode");
        String itemName=request.getParameter("itemName");
        String itemQuantity=request.getParameter("itemQuantity");
        String itemPrice=request.getParameter("itemPrice");

        if (itemCode.equals("")) {
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_Code);
            RequestDispatcher dis = request.getRequestDispatcher("ViewItems.jsp");
            dis.forward(request, response);

        } else if(itemName.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_NAME);
            RequestDispatcher dis = request.getRequestDispatcher("ViewItems.jsp");
            dis.forward(request, response);
        }
        else if(itemQuantity.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_Quantity);
            RequestDispatcher dis = request.getRequestDispatcher("ViewItems.jsp");
            dis.forward(request, response);
        }
        else if(itemPrice.equals("")){
            request.setAttribute(CommonConstants.ERROR_MESSAGE, CommonConstants.ERROR_MESSAGE_ITEM_PRICE);
            RequestDispatcher dis = request.getRequestDispatcher("ViewItems.jsp");
            dis.forward(request, response);
        }else{

            //set data to the variables
            item.setItemId(itemId);
            item.setItemCode(itemCode);
            item.setItemName(itemName);
            item.setQuantity(Integer.parseInt(itemQuantity));
            item.setPrice(Double.parseDouble(itemPrice));

            IItemService iItemService = new ItemServiceImpl();

            if(iItemService.updateItem(item)){
                response.sendRedirect("http://localhost:8080/BCConstruction/ViewItems.jsp");
            }

        }




    }
}
