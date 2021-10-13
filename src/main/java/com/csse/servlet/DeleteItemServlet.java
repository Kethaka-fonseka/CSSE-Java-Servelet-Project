package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteItemServlet", value = "/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Item item=new Item();

        item.setItemId(request.getParameter("id"));
        System.out.println(item.getItemId());
        IItemService iItemService = new ItemServiceImpl();

        if(iItemService.deleteItem(item) == 1){
            response.sendRedirect("http://localhost:8080/BCConstruction/ViewItems.jsp");
        }
    }
}
