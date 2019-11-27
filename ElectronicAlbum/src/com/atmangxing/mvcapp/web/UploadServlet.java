package com.atmangxing.mvcapp.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.atmangxing.mvcapp.dao.ElectonicDAO;
import com.atmangxing.mvcapp.dao.uploadelctionic;
import com.atmangxing.mvcapp.dao.impl.ElectonicdaoJdbcImpl;
import com.atmangxing.mvcapp.domain.Electonic;

@WebServlet("/Upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ElectonicDAO electonicDAO=new ElectonicdaoJdbcImpl();   
   @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
	   
	   HttpSession tsn = request.getSession(true);
	   String name=(String) tsn.getAttribute("name");
	   System.out.println(name);
	   
	   response.setContentType("text/html;charset=utf-8");
	   PrintWriter out = response.getWriter();
	   
	   String downname="";
	   uploadelctionic up=new uploadelctionic(name);
	   List<Electonic> down=electonicDAO.getElectonicname(up);
	   if(down !=null&&down.size()>0) {
	     for(Electonic electonic :down) {
		   
//		   System.out.println(electonic.getElectonicname());
//	       System.out.println(electonic.getPath());
		   String paths=electonic.getPath();
		   String patha=paths.replaceAll("\\\\", "/");
		   System.out.println(patha);
		   downname=downname
		+"<img src=\""+patha+"\" class=\"img1\">";
	    }
	  }else {
		  downname="";
	  }
	   out.println(downname);
	   out.flush();
   }
}
