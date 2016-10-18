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

import com.flp.ems.service.EmployeeServiceImpl;

/**
 * Servlet implementation class modifyUpdate
 */
@WebServlet("/modifyUpdate")
public class modifyUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
		String email=request.getParameter("emailId");	
	String name=request.getParameter("name");
	String phoneNo=request.getParameter("phoneNo");
	String address=request.getParameter("address");
	HashMap<String, String> emp=new HashMap<String,String>();
	EmployeeServiceImpl e=new EmployeeServiceImpl();
	RequestDispatcher rd=request.getRequestDispatcher("modify.jsp");	

	rd.include(request, response);	
	
	
	emp.put("emailId", email);
	if(name!=null && name.isEmpty()==false)
			emp.put("name", name);
	if(phoneNo!=null && phoneNo.isEmpty()==false)	
			emp.put("phoneNo", phoneNo);
	if(address!=null && address.isEmpty()==false)	
			emp.put("address", address);

if(e.ModifyEmployee(emp))
	out.write("<br><br><font color='red'>Employee modified successfully</font>");
else
	out.write("<br><br><font color='red'>Employee couldnt be modified</font>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
