package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDAO;
import com.exceptions.DuplicateIdException;

@WebServlet("/UniversityController")
public class UniversityController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UniversityController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		UserDAO dao = new UserDAO();

		String action = request.getParameter("action");
		RequestDispatcher view = null;

		if (action.equals("register")) {
			view = request.getRequestDispatcher("registration.jsp");
			view.forward(request, response);
		} else if (action.equals("list")) {
			
			List<User> users = dao.registeredStudentList();
			
			//storing the data in request scope
			
			
			//request.setAttribute("userdata", users);
			
			
			//view = request.getRequestDispatcher("list.jsp");
			//view.forward(request, response);
			
			
			ServletContext context = getServletContext();
			
			//storing the data in context scope
			context.setAttribute("userdata", users);
			
			response.sendRedirect("list.jsp");
			
		} else if (action.equals("new")) {
			
			
			int universityNumber = Integer.parseInt(request.getParameter("universityNumber"));
			String studentName = request.getParameter("studentName");
			String sex = request.getParameter("sex");

			// passing the values to the registerUser class
			User user = new User(universityNumber, studentName, sex);
			try {
				boolean regStuStatus = dao.registerStudent(user);
				//view = request.getRequestDispatcher("home.jsp");
				
				//creates a new request for home.jsp
				response.sendRedirect("home.jsp");

				
			} catch (DuplicateIdException e) {
				request.setAttribute("errormessage", e.getMessage());
				view = request.getRequestDispatcher("registration.jsp");
				view.forward(request, response);
				//response.sendRedirect("registration.jsp");
			}
			

		}

		
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
