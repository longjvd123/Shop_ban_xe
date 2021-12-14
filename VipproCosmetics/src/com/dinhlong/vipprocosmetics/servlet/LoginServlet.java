package com.dinhlong.vipprocosmetics.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.entity.User;
import com.dinhlong.vipprocosmetics.service.CosmeticsService;
import com.dinhlong.vipprocosmetics.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		User user = new User();
		UserService userService = new UserService();
		user = userService.loginUser(username, password);
		if (user != null) {

			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("role", user.getRole());
			CosmeticsService cosmeticsService = new CosmeticsService();
			List<Cosmetics> cosmetics = cosmeticsService.getAllCosmetics();
			
			request.setAttribute("cosmetics", cosmetics);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/homepage.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Login failed");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
