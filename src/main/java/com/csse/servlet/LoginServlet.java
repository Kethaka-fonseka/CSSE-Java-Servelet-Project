package com.csse.servlet;


import com.csse.model.LoginBean;
import com.csse.model.Staff;
import com.csse.model.Supplier;
import com.csse.model.User;
import com.csse.service.ILoginService;
import com.csse.service.LoginServiceImpl;
import com.csse.service.RegisterServiceImpl;
import com.csse.service.StaffServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String userEmail = request.getParameter("user_email");
		String userPass = request.getParameter("user_pass");
		
		LoginBean loginBean = new LoginBean();
		loginBean.setUserEmail(userEmail);
		loginBean.setUserPass(userPass);
		LoginServiceImpl loginService = new LoginServiceImpl();

		if (loginService.validate(loginBean)) {
			HttpSession session = request.getSession();
			ILoginService iLoginService = new LoginServiceImpl();
			User user = iLoginService.getUserByEmail(userEmail);

					session.setAttribute("user",user);
					System.out.println("Hello " + user.getUserName());

			if(user.getUserRole().equals("staff")){
				Staff staff = new StaffServiceImpl().getStaffByID(user.getUserId());
				session.setAttribute("staff",staff);
				System.out.println("Hello " + staff.getUserName());

			}else if(user.getUserRole().equals("supplier")){
				Supplier supplier = new RegisterServiceImpl().getSupplierByID(user.getUserId());
				session.setAttribute("supplier",supplier);
				System.out.println("Hello " + supplier.getUserName());
			}else{
				System.out.println("there is another user role");
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Head.jsp");
			requestDispatcher.forward(request, response);
		}

		else {

			request.setAttribute("errMessage", "You are not registered");
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			out.print("Invalid");
		}


	}
}
