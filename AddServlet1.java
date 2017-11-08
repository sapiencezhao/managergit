package Servlet;

import java.util.List;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.User1;

/**
 * Servlet1 implementation class AddServlet1
 */

public class AddServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1473486348546537776L;
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String add = request.getParameter("add");
		User1 user = new User1();
		user.setName(name);
		user.setSex(sex);
		user.setAdd(add);
		ServletContext application = getServletContext();
		List<User1> list = (List<User1>) application.getAttribute("users");
		if(list==null) {
			list = new ArrayList<User1>();
		}
		list.add(user);
		application.setAttribute("users", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("manager1.jsp");
		dispatcher.forward(request, response);
		
		
		
		doGet(request, response);
	}

}
