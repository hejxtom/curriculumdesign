package com.atmangxing.mvcapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmangxing.mvcapp.dao.CriteriaUser;
import com.atmangxing.mvcapp.dao.UserDAO;
import com.atmangxing.mvcapp.dao.impl.UserDAOJdbcImpl;
import com.atmangxing.mvcapp.domain.User;

@WebServlet("/UserLoginSevlrt")
public class UserLoginSevlrt extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private UserDAO userdao=new UserDAOJdbcImpl();   
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 System.out.println(username);
		 System.out.println(password);
		 CriteriaUser cu=new CriteriaUser(username,password);
		 List<User> users=userdao.getForListWithCriteriaUser(cu);
		 if(users !=null &&users.size()>0) {
			 response.sendRedirect("StundentForm.jsp");
		 }else {
			request.setAttribute("LoginErro", "您的用户名或者密码错误");
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		 }
	}

}
