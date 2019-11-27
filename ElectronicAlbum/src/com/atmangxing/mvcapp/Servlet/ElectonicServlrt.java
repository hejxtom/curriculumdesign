package com.atmangxing.mvcapp.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmangxing.mvcapp.dao.Criteriaelectionic;
import com.atmangxing.mvcapp.dao.ElectonicDAO;
import com.atmangxing.mvcapp.dao.impl.ElectonicdaoJdbcImpl;
import com.atmangxing.mvcapp.domain.Electonic;

@WebServlet("/ElectonicServlrt")
public class ElectonicServlrt extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private ElectonicDAO electonicDAO=new ElectonicdaoJdbcImpl();
    
    public ElectonicServlrt() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String servletPath=request.getServletPath();
    	String methodName=servletPath.substring(1);
    	methodName=methodName.substring(0,methodName.length()-3);
    	Method method;
		try {
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
				method.invoke(this, request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	private void query(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		System.out.println("query");
		String name =request.getParameter("username");
		String password=request.getParameter("password");
//		System.out.println(name+" "+password);
		Criteriaelectionic  cc =new Criteriaelectionic(name,password);
		List<Electonic> electonics=electonicDAO.getForListWithCriteriaCustomer(cc);
    	request.setAttribute("electonics", electonics);
		if(electonics !=null &&electonics.size()>0) {
			for(Electonic electonic:electonics) {
				name=electonic.getName();
			}
			request.setAttribute("name", name);
	    	request.getRequestDispatcher("upload.jsp").forward(request, response);
		}else {
			response.sendRedirect("index");
		}
//		System.out.println(electonics);
	}
    private void addElectonic(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
    	//System.out.println("addElectonic");
    	String name=request.getParameter("username");
    	String password=request.getParameter("password");
    	String phone=request.getParameter("phone_number");
    	String mailbox=request.getParameter("email");
    	
    	long count =electonicDAO.getCountWithName(name);
    	
    	if(count>0) {
			request.setAttribute("message", "用户名"+name+"已被占用，请重新选择！");
			request.getRequestDispatcher("/erro.jsp").forward(request, response);
			return;
		}
    	Electonic electonic =new Electonic(name,password,phone,mailbox);
    	electonicDAO.save(electonic);
    	response.sendRedirect("success.jsp");
    }
}
