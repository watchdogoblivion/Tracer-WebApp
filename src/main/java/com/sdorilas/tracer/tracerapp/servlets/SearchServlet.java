package com.sdorilas.tracer.tracerapp.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sdorilas.tracer.tracerapp.dto.Question;
import com.sdorilas.tracer.tracerapp.repositories.QuestionRepository;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	QuestionRepository qR;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String selection = request.getParameter("Selection");
		String query;
		int increment;
		int currentPage;
		if (selection.equals("Default")) {
			query = request.getParameter("search_field");
			currentPage = 1;
			increment = 0;
			if (query == null || query.isEmpty()) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("_base-jsps/index.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
		} else {
			currentPage = (int) session.getAttribute("CurrentPage");
			query = (String) session.getAttribute("Query");
			increment = (int) session.getAttribute("Increment");
			switch (selection) {
			case "previous":
				if(currentPage % 11 == 0) {
					increment -= 10;
				}
				currentPage -= 1;
				break;
			case "jumpPrevious":
				increment -= 10;
				currentPage -= 10;
				break;
			case "next":
				if(currentPage % 10 == 0) {
					increment += 10;
				}
				currentPage += 1;
				break;
			case "jumpNext":
				increment += 10;
				currentPage += 10;
				break;
			case "goTo":
				query = (String) session.getAttribute("Query");
				currentPage = Integer.parseInt(request.getParameter("Page"));
				break;
			}
		}

		long pageSize = 1;
		long pageCount = (long) Math.ceil((double) (qR.count()) / pageSize);
		Pageable sortedByDateNameDesc = PageRequest.of(currentPage - 1, (int) pageSize,
				Sort.by("date_time").descending().and(Sort.by("question")));
		List<Question> questions = qR.RetrieveByQuery(query, sortedByDateNameDesc);

		session.setAttribute("Query", query);
		session.setAttribute("Increment", increment);
		session.setAttribute("CurrentPage", currentPage);
		session.setAttribute("PageCount", pageCount);
		request.setAttribute("Questions", questions);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("_pages-jsps/search.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
