package com.atmangxing.mvcapp.web;

import javax.servlet.*;
import javax.servlet.http.*;

import com.atmangxing.mvcapp.dao.ElectonicDAO;
import com.atmangxing.mvcapp.dao.uploadelctionic;
import com.atmangxing.mvcapp.dao.impl.ElectonicdaoJdbcImpl;

import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">www</a>
 * <br/>Copyright (C), 2001-2018, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(name="DownServlet" , urlPatterns={"/Down"})
@MultipartConfig
public class DownServlet extends HttpServlet{
	private ElectonicDAO electonicDAO=new ElectonicdaoJdbcImpl();
	public void service(HttpServletRequest request ,HttpServletResponse response)
	throws IOException , ServletException{
		request.setCharacterEncoding("utf-8");
		// ��ȡ��ͨ�������
		String name=request.getParameter("name");
		// ��ȡ�ļ��ϴ���
		Part part = request.getPart("cover");
		// ��ȡ����ԭʼ�ļ������ַ���
		String fileNameInfo = part.getHeader("Content-Disposition");
		// ��ȡ�ϴ��ļ���ԭʼ�ļ���
		String fileName = fileNameInfo.substring(
			fileNameInfo.indexOf("filename=\"") + 10 , fileNameInfo.length() - 1);
		// ���ϴ����ļ�д�������
		part.write(getServletContext().getRealPath("/")
			+ "/" + UUID.randomUUID()
			+ fileName.substring(fileName.lastIndexOf(".")));  
		 String electonicname=fileName;
		String[] sourceStrArray = electonicname.split("\\\\");
		for (int i = 0; i < sourceStrArray.length; i++) {
           electonicname= sourceStrArray[sourceStrArray.length-1];
        }
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<div src=\""+fileName+"\" id=\"showA\">" + electonicname+"</div>");
		out.flush();
		
		uploadelctionic up=new uploadelctionic(name, electonicname, fileName);
	    electonicDAO.upload(up);
	}
}