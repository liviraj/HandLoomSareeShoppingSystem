package com.hsss.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsss.model.ProductDetails;
import com.hsss.service.HandLoomService;


@WebServlet("/HandLoomController")
public class HandLoomController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String VIEW_CART_PAGE = "ViewCart.jsp";
	private static final String PLACE_ORDER_PAGE = "PlaceOrder.jsp";
	private static final String LOGIN = "login.jsp";
	private static final String HAND_LOOM_PAGE = "handloom.jsp";
	RequestDispatcher requestDispatcher = null;

	public HandLoomController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("action");
		String navigation = "";
		if (action.equals("addCart")) {
			if (check != null) {
				HandLoomService service = new HandLoomService();
				int loginId = Integer.parseInt(request.getParameter("loginId"));
				int itemId = Integer.parseInt(request.getParameter("itemId"));
				
				int insertToCart = service.insertToCart(loginId, itemId);
				if (insertToCart > 0) {
					request.setAttribute("msg", "Item added in cart");
					request.setAttribute("loginId", loginId);
					navigation = HAND_LOOM_PAGE;
				}
				
			} else {
				requestDispatcher = request.getRequestDispatcher(LOGIN);
			}
		} else if(action.equals("viewCart")) {
			HandLoomService service = new HandLoomService();
			int loginId = Integer.parseInt(request.getParameter("loginId"));
			
			List<ProductDetails> cardDetails = service.getCardDetails(loginId);
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("details", cardDetails);
			navigation = VIEW_CART_PAGE;
		} else if (action.equals("product")) {
			HandLoomService service = new HandLoomService();
			int loginId = Integer.parseInt(request.getParameter("loginId"));
			
			request.setAttribute("loginId", loginId);
			navigation = HAND_LOOM_PAGE;
			
		}

		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("submit");

		requestDispatcher.forward(request, response);
	}
}
