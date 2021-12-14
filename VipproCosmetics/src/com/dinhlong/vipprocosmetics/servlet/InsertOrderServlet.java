package com.dinhlong.vipprocosmetics.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.entity.Order;
import com.dinhlong.vipprocosmetics.service.CosmeticsService;
import com.dinhlong.vipprocosmetics.service.OrderService;
import com.dinhlong.vipprocosmetics.util.FileUtil;

/**
 * Servlet implementation class InsertOrderServlet
 */
@WebServlet("/InsertOrderServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 100
		)
public class InsertOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = new OrderService();
		List<Order> order = orderService.getAllOrder();
		request.setAttribute("order", order);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/insertOrder.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		OrderService orderService = new OrderService();
		String name = request.getParameter("name").toString();
		int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
		String address = request.getParameter("address").toString();
		int totalMoney = Integer.parseInt(request.getParameter("totalMoney"));
		orderService.insertOrder(name, phoneNumber, address, totalMoney);
		
		response.sendRedirect(request.getContextPath()+"/HomeServlet");
	}

}
