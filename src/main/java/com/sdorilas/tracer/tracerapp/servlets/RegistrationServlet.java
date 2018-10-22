package com.sdorilas.tracer.tracerapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserRepository userRepository;
	private String warning = "";
	String newline = "\r\n";
	String bullet = "&#8226; ";
       
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
		User user = createUser(request, response);
		validateFirstname(user);
		validateLastname(user);
		validateUsername(user);
		validateEmail(user);
		validatePassword(request, response);
		
		boolean check = warning.equals("");
		RequestDispatcher requestDispatcher;
		if (check) {
			requestDispatcher = request.getRequestDispatcher("_base-jsps/login.jsp");
		}else {
			request.setAttribute("USER", user);
			request.setAttribute("WARNINGS", warning);
			warning = "";
			requestDispatcher = request.getRequestDispatcher("_base-jsps/registration.jsp");
		}
		requestDispatcher.forward(request, response);
	}

	private void validatePassword(HttpServletRequest request, HttpServletResponse response) {
		String password = request.getParameter("password");
		String psw_repeat = request.getParameter("psw_repeat");
		String regex = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])\\w{6,}$/";
		if (!password.matches(regex)) {
			warning+= "Password requires:" + newline + bullet + "At least one number " + newline + bullet +"At least one lowercase "
					+ newline + bullet + "At least one uppercase letter." 
				+ newline + bullet + "At least six characters." + newline;
		}
		if(!password.equals(psw_repeat)) {
			warning+= "Passwords do not match.";
		}
		password = "";
		psw_repeat = "";
	}

	private void validateEmail(User user) {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if (!user.getEmail().matches(regex)) {
			warning+="Invalid Email" + newline;
		}
	}

	private void validateUsername(User user) {
		String regex = "/^[A-Za-z-']{1,32}$/";
		if (!user.getUsername().matches(regex)) {
			warning+="Invalid username, please use only letters and numbers" + newline;
		}
		List<User> users = userRepository.findAll();
		for (User u: users) {
			if (user.getUsername().equals(u.getUsername())) {
				warning+="User Name " + user.getUsername() + " already exists" + newline;
			}
		}
	}

	private void validateLastname(User user) {
		String regex = "/^[A-Za-z-']{1,32}$/";
		if (!user.getLast_name().matches(regex)) {
			warning+="Invalid last name, please use Letters, dashes, and apostrophes." + newline;
		}
	}

	private void validateFirstname(User user) {
		String regex = "/^[A-Za-z-']{1,32}$/";
		if (!user.getFirst_name().matches(regex)) {
			warning+="Invalid first name, please use Letters, dashes, and apostrophes." + newline;
		}
	}

	private User createUser(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		User user = new User(userName, firstName, lastName, email, "");
		return user;
	}

}
