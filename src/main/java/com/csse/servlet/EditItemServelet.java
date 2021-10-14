package com.csse.servlet;

import com.csse.model.Item;
import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
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

        //set data to the variables
        String Id = request.getParameter("id");

        try {
            IItemService iItemService = new ItemServiceImpl();
            Item item= iItemService.editItem(Id);
            request.setAttribute("item",item);
            RequestDispatcher dis = request.getRequestDispatcher("EditItems.jsp");
            dis.forward(request, response);

        } catch (ClassNotFoundException | SQLException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

    }
}
