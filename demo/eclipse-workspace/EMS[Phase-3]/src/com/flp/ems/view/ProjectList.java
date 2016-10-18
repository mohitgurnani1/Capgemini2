package com.flp.ems.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class ProjectList
 */
@WebServlet("/project")
public class ProjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String s=request.getParameter("val");
		HashMap projlist;	
		EmployeeServiceImpl e=new EmployeeServiceImpl();	
		projlist=e.getProjectList(s);
			if(projlist==null || projlist.isEmpty())
				{
					out.write("<option>Kindly Select another Department</option>");
				}
			Set set2=projlist.entrySet();
			for(Object proj:set2)
			{
				Map.Entry<String, String> m=(Map.Entry<String, String>)proj;
						out.write(" <option value="+(String)m.getKey()+">"+(String)m.getValue()+"</option>");
			}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
