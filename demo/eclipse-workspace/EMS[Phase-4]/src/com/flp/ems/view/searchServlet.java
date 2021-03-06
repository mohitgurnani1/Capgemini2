package com.flp.ems.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, String> emp=new HashMap<String,String>();
	
		WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		EmployeeServiceImpl e=applicationContext.getBean("service",EmployeeServiceImpl.class);
		
		String name=request.getParameter("name");
		String kinId=request.getParameter("kinId");
		String emailId=request.getParameter("emailId");
		
		if(name!=null && name.isEmpty()==false)
			emp.put("name", name);
		if(kinId!=null && kinId.isEmpty()==false)
			emp.put("kinId", kinId);
		if(emailId!=null && emailId.isEmpty()==false)
			emp.put("emailId", emailId);
		
		HashMap<String,String> hm=e.SearchEmployee(emp);
		
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		rd.include(request, response);
		PrintWriter out=response.getWriter();
		
		
		out.write("<div class='panel panel-default'>"
+" <div class='panel-heading'> <table class='table'>"
+	"    <thead>"
+	      "<tr>"
+	        "<th>Kin Id</th>"
+	        "<th>Email Id</th>"
+	        "<th>Name</th>"
+	        "<th>Role</th>"
+	        "<th>Department</th>"
+	       " <th>Project</th>"
+	      "</tr>"
+	    "</thead>"
+	   " </div>");
		if(hm!=null)
		out.write("	<div class='panel-body'><tr> <td>"+hm.get("kinId")+"</td> <td>"+hm.get("emailId")+"</td><td>"+hm.get("name")+" </td><td>"+hm.get("role")+"</td>  <td>"+hm.get("dept")+"</td>  <td>"+hm.get("project")+"</td></tr>  </div>	</div>");
	     
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
