package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditItemServlet")
public class EditItemServelet extends HttpServlet {
    public EditItemServelet() {
        super();
    }
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

        Item item = new Item();

        //set data to the variables
        item.setItemName(request.getParameter("itemName"));
        item.setItemCode(request.getParameter("itemCode")); //item code is the unique key
        item.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        item.setPrice(Double.parseDouble(request.getParameter("price")));


        IItemService iItemService = new ItemServiceImpl();
        iItemService.editItem(item);
        //set attribute
        request.setAttribute("item", item);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewItems.jsp");
        dispatcher.forward(request, response);
    }
}
