package com.atmangxing.mvcapp.Servlet.regic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atmangxing.mvcapp.domain.Electonic;

@WebServlet("/index")
public class indexregic extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
			request.setAttribute("IndexErro", "您的用户名或者密码错误!");
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}


