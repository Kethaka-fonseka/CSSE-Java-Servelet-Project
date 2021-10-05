package com.csse.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csse.model.Supplier;
import com.csse.model.User;
import com.csse.service.IRegisterService;
import com.csse.service.RegisterServiceImpl;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		User user = new User();
		Supplier supplier = new Supplier();
		
		user.setUserRole("supplier");
		user.setUserName(request.getParameter("user_name"));
		user.setUserMail(request.getParameter("email"));
		user.setUserPass(request.getParameter("pass"));
		supplier.setCompanyName(request.getParameter("company_name"));
		supplier.setContactNumber(Integer.parseInt(request.getParameter("mob_num")));

		IRegisterService iRegisterService = new RegisterServiceImpl();

		if(!iRegisterService.addSupplier(user, supplier)){
//		request.setAttribute("errMessage","Supplier Added Successfully!");
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewSupplier.jsp");
		requestDispatcher.forward(request, response);

	}else{
//			request.setAttribute("errMessage","There was an Error!");
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ViewSupplier.jsp");
			requestDispatcher.forward(request, response);
		}
}
}
