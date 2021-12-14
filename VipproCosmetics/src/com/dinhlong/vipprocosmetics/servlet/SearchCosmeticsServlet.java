	package com.dinhlong.vipprocosmetics.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.service.CosmeticsService;

/**
 * Servlet implementation class SearchCosmeticsServlet
 */
@WebServlet("/SearchCosmeticsServlet")
public class SearchCosmeticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCosmeticsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SearchCosmetics.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name").toString();
		
		CosmeticsService cosmeticsService = new CosmeticsService();
		List<Cosmetics> cosmetics = cosmeticsService.findCosmeticsByName(name);
		request.setAttribute("cosmetics", cosmetics);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SearchCosmetics.jsp");//searchResults
		dispatcher.forward(request, response);
	}

}
