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
//		 else if (action.equals("cancel")) {
//			navigation = "home.jsp";
//		} else if (action.equals("update")) {
//			if (check != null) {
//				EmployeeService serverService = new EmployeeService();
//				RationCardModel model = new RationCardModel();
//				int employeeId = Integer.parseInt(request.getParameter("employeeId"));
//				try {
//					model = serverService.getById(employeeId);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//				request.setAttribute("name", "update");
//				request.setAttribute("details", model);
//				navigation = VIEW_CART_PAGE;
//			} else {
//				requestDispatcher = request.getRequestDispatcher(LOGIN);
//			}
//		} else if (action.equals("delete")) {
//			String confirm = request.getParameter("confirm");
//			if (check != null) {
//				if (!"false".equals(confirm)) {
//					EmployeeService service = new EmployeeService();
//					int employeeId = Integer.parseInt(request.getParameter("employeeId"));
//					try {
//						int reult = service.deleteById(employeeId);
//						if (reult == 1) {
//							ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
//							EmployeeService service2 = new EmployeeService();
//							try {
//								dataList = service2.getAllList();
//							} catch (ClassNotFoundException e) {
//								e.printStackTrace();
//							}
//							request.setAttribute("details", dataList);
//							navigation = PLACE_ORDER_PAGE;
//						}
//					} catch (ClassNotFoundException e) {
//						e.printStackTrace();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				} else {
//					requestDispatcher = request.getRequestDispatcher(LOGIN);
//				}
//			}
//		} else if (action.equals("add")) {
//			if (check != null) {
//				request.setAttribute("name", "save");
//				navigation = VIEW_CART_PAGE;
//			} else {
//				requestDispatcher = request.getRequestDispatcher(LOGIN);
//			}
//		} else {
//			if (check != null) {
//				ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
//				EmployeeService service = new EmployeeService();
//				try {
//					dataList = service.getAllList();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//				request.setAttribute("details", dataList);
//				navigation = PLACE_ORDER_PAGE;
//			} else {
//				requestDispatcher = request.getRequestDispatcher(LOGIN);
//			}
//		}
		requestDispatcher = request.getRequestDispatcher(navigation);
		requestDispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String check = (String) session.getAttribute("username");
		String action = request.getParameter("submit");
//		ArrayList<RationCardModel> arrayList = new ArrayList<RationCardModel>();
//		if (action.equals("save")) {
//			if (check != null) {
//				RationCardModel model = new RationCardModel();
//				EmployeeService service = new EmployeeService();
//				String employeeCode = request.getParameter("employeeCode");
//				String employeeName = request.getParameter("name");
//
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				java.util.Date dobReq = null;
//				try {
//					String reqDate = request.getParameter("dob");
//					dobReq = dateFormat.parse(reqDate);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Date dobDate = new Date(dobReq.getTime());
//
//				String designation = request.getParameter("designation");
//				String gender = request.getParameter("gender");
//
//				int experiance = Integer.parseInt(request.getParameter("experiance"));
//				String contactNumber = request.getParameter("contactNumber");
//
//				model.setEmployeeCode(employeeCode);
//				model.setDob(dobDate);
//				model.setName(employeeName);
//				model.setGender(gender);
//				model.setDesignation(designation);
//				model.setExperiance(experiance);
//				model.setContactNumber(contactNumber);
//
//				String result = service.check(employeeCode);
//				arrayList.add(model);
//				if (result.equals("success")) {
//					request.setAttribute("name", "save");
//					request.setAttribute("msg", "Employee Code Already Exist");
//					request.setAttribute("details", model);
//					requestDispatcher = request.getRequestDispatcher(VIEW_CART_PAGE);
//				} else {
//					int status = service.insertToCart(model);
//					if (status > 0) {
//						ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
//						EmployeeService service2 = new EmployeeService();
//						try {
//							dataList = service2.getAllList();
//						} catch (ClassNotFoundException e) {
//							e.printStackTrace();
//						}
//						request.setAttribute("details", dataList);
//						requestDispatcher = request.getRequestDispatcher(PLACE_ORDER_PAGE);
//					}
//				}
//			} else {
//				requestDispatcher = request.getRequestDispatcher(LOGIN);
//			}
//		} else if (action.equals("Cancel")) {
//			if (check != null) {
//				ArrayList<RationCardModel> model = new ArrayList<RationCardModel>();
//				EmployeeService service = new EmployeeService();
//				try {
//					model = service.getAllList();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//				request.setAttribute("details", model);
//				// navigation=viewemp;
//				requestDispatcher = request.getRequestDispatcher(PLACE_ORDER_PAGE);
//			} else {
//				requestDispatcher = request.getRequestDispatcher(LOGIN);
//			}
//		} else {
//			if (check != null) {
//				RationCardModel model = new RationCardModel();
//				EmployeeService service = new EmployeeService();
//				ArrayList<RationCardModel> dataList = new ArrayList<RationCardModel>();
//
//				int id = Integer.parseInt(request.getParameter("employeeId"));
//				String employeeCode = request.getParameter("employeeCode");
//				String employeeName = request.getParameter("name");
//
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				java.util.Date dobReq = null;
//				try {
//					String reqDate = request.getParameter("dob");
//					dobReq = dateFormat.parse(reqDate);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Date dobDate = new Date(dobReq.getTime());
//
//				String designation = request.getParameter("designation");
//				String gender = request.getParameter("gender");
//
//				int experiance = Integer.parseInt(request.getParameter("experiance"));
//				String contactNumber = request.getParameter("contactNumber");
//
//				model.setEmployeeCode(employeeCode);
//				model.setDob(dobDate);
//				model.setName(employeeName);
//				model.setGender(gender);
//				model.setDesignation(designation);
//				model.setExperiance(experiance);
//				model.setContactNumber(contactNumber);
//				model.setEmployeeId(id);
//				try {
//					int status = service.update(model);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//				try {
//					dataList = service.getAllList();
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//				request.setAttribute("details", dataList);
//				request.setAttribute("msg", "record updated successfully");
//				requestDispatcher = request.getRequestDispatcher(PLACE_ORDER_PAGE);
//			} else {
//				requestDispatcher = request.getRequestDispatcher(LOGIN);
//			}
//		}
		requestDispatcher.forward(request, response);
	}
}
