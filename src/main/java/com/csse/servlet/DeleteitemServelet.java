package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteitemServelet extends HttpServlet {

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
        item.setItemId(request.getParameter("deleteID"));

        IItemService iItemService = new ItemServiceImpl();
        iItemService.deleteItem(item);


        request.setAttribute("item", item);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewItems.jsp");
        dispatcher.forward(request, response);

    }
}
