package com.atmangxing.mvcapp.Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.INACTIVE;

import com.atmangxing.mvcapp.dao.CriteriaStudent;
import com.atmangxing.mvcapp.dao.StudentDAO;
import com.atmangxing.mvcapp.dao.impl.StudentDAOJdbcImpl;
import com.atmangxing.mvcapp.domain.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO studentdao=new StudentDAOJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException,IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String number=request.getParameter("number");
		try {
			studentdao.delete(number);
		}catch(Exception e){}
		response.sendRedirect("query.do");
	} 
	
	private void query(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String grade=request.getParameter("grade");
		CriteriaStudent cs=new CriteriaStudent(number, name, sex, age, grade);
		List<Student> students=studentdao.getForListWithCriteriaCustomer(cs);
		request.setAttribute("students", students);
		request.getRequestDispatcher("/StundentForm.jsp").forward(request, response);
	} 
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String grade=request.getParameter("grade");
		
		long count=studentdao.getCountWithName(name);
		if(count>0) {
			request.setAttribute("message", "用户名"+name+"已被占用，请重新选择！");
			request.getRequestDispatcher("/newCustomer.jsp").forward(request, response);
			return;
		}
		Student student =new Student(number, name, sex, age, grade);
		studentdao.save(student);
		response.sendRedirect("success.jsp");
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forwardPath="/erro.jsp";
		String number =request.getParameter("number");
		try {
			Student student =studentdao.get(number);
			if(student !=null) {
				forwardPath="/updatecustomer.jsp";
				request.setAttribute("student", student);
			}
		}catch (Exception e) {}
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws 
	           ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String number=request.getParameter("number");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String grade=request.getParameter("grade");
		String oldName=request.getParameter("oldName");
		if(!oldName.equalsIgnoreCase(name)) {
			long count=studentdao.getCountWithName(name);
			if(count>0) {
				request.setAttribute("message", "用户名"+name+"已被占用，请重新选择！");
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		Student student=new Student(number, name, sex, age, grade);
		studentdao.update(student);
		response.sendRedirect("query.do");
	}
	 
}
