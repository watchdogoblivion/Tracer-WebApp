package com.sdorilas.tracer.tracerapp.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.sdorilas.tracer.tracerapp.dto.Mail;
import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;
import com.sdorilas.tracer.tracerapp.services.EmailService;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/Forgot-Password")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserRepository userRepository;
	private String warning = "";
	String newline = "\r\n";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgotPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(
	    		this,
	      config.getServletContext());
	  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("TEST1", true);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("_base-jsps/forgot_password.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		emailExists(email);
		boolean check = warning.equals("");
		RequestDispatcher requestDispatcher;
		if (check) {
			emailPassword(email);
			request.setAttribute("TEST1", false);
			request.setAttribute("TEST2", true);
			requestDispatcher = request.getRequestDispatcher("_base-jsps/forgot_password.jsp");
		} else {
			request.setAttribute("TEST1", true);
			request.setAttribute("WARNING", warning);
			warning = "";
			requestDispatcher = request.getRequestDispatcher("_base-jsps/forgot_password.jsp");
		}
		requestDispatcher.forward(request, response);
	}

	private void emailPassword(String email) {
		String password = generatePassword();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (email.equals(user.getEmail())) {
				user.setPassword(password);
				userRepository.save(user);
			}
		}
		Mail mail = new Mail();
		mail.setFrom("sdorilas-tracer.herokuapp.com");
		mail.setTo(email);
		mail.setSubject("Password Retrieval");
		mail.setContent("Your new password is " + password);
		emailService.sendSimpleMessage(mail);
		password = null;
	}

	private String generatePassword() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();
		return generatedString;
	}

	private void emailExists(String email) {
		List<User> users = userRepository.findAll();
		boolean check = false;
		for (User user : users) {
			if (email.equals(user.getEmail())) {
				check = true;
			}
		}
		if (!check) {
			warning += "Email does not exist";
		}
	}

}
