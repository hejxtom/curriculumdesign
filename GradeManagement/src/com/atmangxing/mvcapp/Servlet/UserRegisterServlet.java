package com.atmangxing.mvcapp.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmangxing.mvcapp.dao.CriteriaUser;
import com.atmangxing.mvcapp.dao.UserDAO;
import com.atmangxing.mvcapp.dao.impl.UserDAOJdbcImpl;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDAO userdao=new UserDAOJdbcImpl();
	
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
    	
    	long count =userdao.getCountWithName(username);
    	if(count>0) {
    		request.setAttribute("RegisterErro", "�û���"+username+"�ѱ�ռ�ã�������ѡ��");
    		request.getRequestDispatcher("/erro.jsp").forward(request, response);
    		return;
    	 }
    	CriteriaUser cu=new CriteriaUser(username,password);
    	userdao.save(cu);
    	request.setAttribute("Register", "ע��ɹ���");
    	request.getRequestDispatcher("success.jsp").forward(request, response);
    }
	
}
