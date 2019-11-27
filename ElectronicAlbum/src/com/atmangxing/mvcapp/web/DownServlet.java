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
 * <br/>网站: <a href="http://www.crazyit.org">www</a>
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
		// 获取普通请求参数
		String name=request.getParameter("name");
		// 获取文件上传域
		Part part = request.getPart("cover");
		// 获取包含原始文件名的字符串
		String fileNameInfo = part.getHeader("Content-Disposition");
		// 提取上传文件的原始文件名
		String fileName = fileNameInfo.substring(
			fileNameInfo.indexOf("filename=\"") + 10 , fileNameInfo.length() - 1);
		// 将上传的文件写入服务器
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