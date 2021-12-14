package com.dinhlong.vipprocosmetics.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.service.CosmeticsService;
import com.dinhlong.vipprocosmetics.util.FileUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 100
		)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CosmeticsService cosmeticsService = new CosmeticsService();
		String id  = (request.getParameter("id"));
		Cosmetics cosmetics = cosmeticsService.getCosmetics(id);
		request.setAttribute("cosmetics",cosmetics);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/updateCosmetics.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CosmeticsService cosmeticsService = new CosmeticsService();
		String id= request.getParameter("id");
		String code = request.getParameter("code").toString();
		String name = request.getParameter("name").toString();
		String trademark = request.getParameter("trademark").toString();
		String type = request.getParameter("type").toString();
		String description = request.getParameter("description").toString();
		String origin = request.getParameter("origin").toString();
		String expirydate = request.getParameter("expirydate").toString();
		String dateofmanufacture = request.getParameter("dateofmanufacture").toString();
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		Integer price = Integer.parseInt(request.getParameter("price"));
		String fileName=FileUtil.writeFile(request);
		cosmeticsService.updateCosmetics(id, code, name, trademark, type, description, origin, expirydate, dateofmanufacture, quantity,price, fileName);
		response.sendRedirect(request.getContextPath()+"/AdminCosmeticsServlet");
	}

}
