package com.csse.servlet;


import com.csse.service.IItemService;
import com.csse.service.ItemServiceImpl;
import org.xml.sax.SAXException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/DisplayServlet")
public class DisplayItemServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            IItemService item = new ItemServiceImpl();
            item.getItem();
            RequestDispatcher dis = request.getRequestDispatcher("ViewItems.jsp");
            dis.forward(request, response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
