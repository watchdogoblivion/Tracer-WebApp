package com.sdorilas.tracer.tracerapp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("_base-jsps/registration.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String psw_repeat = request.getParameter("psw_repeat");
		User user = new User(userName, firstName, lastName, email, "");
		password = "";
		psw_repeat = "";
		boolean check = false;
		RequestDispatcher requestDispatcher;
		if (check) {
			requestDispatcher = request.getRequestDispatcher("_base-jsps/login.jsp");
		}else {
			request.setAttribute("USER", user);
			requestDispatcher = request.getRequestDispatcher("_base-jsps/registration.jsp");
		}
		
		requestDispatcher.forward(request, response);
	}

}
