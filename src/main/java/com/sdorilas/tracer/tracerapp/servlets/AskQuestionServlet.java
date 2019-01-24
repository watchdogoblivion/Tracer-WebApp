package com.sdorilas.tracer.tracerapp.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sdorilas.tracer.tracerapp.dto.Question;
import com.sdorilas.tracer.tracerapp.dto.User;
import com.sdorilas.tracer.tracerapp.repositories.QuestionRepository;
import com.sdorilas.tracer.tracerapp.repositories.UserRepository;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/AskQuestion")
@Transactional
public class AskQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	QuestionRepository qR;
	@Autowired
	UserRepository uR;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("_base-jsps/ask_question.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getUserPrincipal().getName();
		User user = uR.findByUsername(username);
		String q = request.getParameter("question");
		Question question = new Question(q);
		question.setUser(user);
		LocalDateTime ldt = LocalDateTime.now();
		question.setDateTime(ldt);
		qR.save(question);
		response.sendRedirect(request.getContextPath());
	}

}
