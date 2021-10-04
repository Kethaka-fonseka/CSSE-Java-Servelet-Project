package com.csse.servlet;


import com.csse.model.LoginBean;
import com.csse.service.LoginServiceImpl;

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
			if (session !=null) {
				session.setAttribute("email",loginBean.getUserEmail());
				out.print("Hello " + loginBean.getUserEmail());
			}

			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/landPageCusView.jsp");
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
