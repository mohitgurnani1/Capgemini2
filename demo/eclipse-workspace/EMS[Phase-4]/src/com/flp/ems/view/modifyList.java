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
 * Servlet implementation class modifyList
 */
@WebServlet("/modifyServlet")
public class modifyList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	
//getServletContext().setIn
	
	String emailId=request.getParameter("email");
	System.out.println("email="+emailId);

	WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	EmployeeServiceImpl e=applicationContext.getBean("service",EmployeeServiceImpl.class);
	
	
	HashMap<String, String> h=e.getEmployeeByEmailId(emailId);
	

	RequestDispatcher rd=request.getRequestDispatcher("modify.jsp");
	rd.include(request, response);
	
	
	out.write("<div class='row'><div class='col-md-1'></div><div class='col-md-8'>");
	
	out.write("<form   method='post' action='modifyUpdate?emailId="+(String)h.get("emailId")+"'>");

	out.write("<div class='form-group'>"+
			"<label for='email'>Email Id:</label>"+
			"<p class='form-control-static' id='email' name='emailId' >"+(String)h.get("emailId") +"</p></div>");
	
	
	out.write("<div class='form-group'>"+
			"<label for='name'>Name:</label>"+
			"<input type='text' class='form-control' id='name' name='name' placeholder=' "+(String)h.get("name") +"  '></div>");
	
	
	out.write("<div class='form-group'>"+
			"<label for='phoneNo'>Phone No:</label>"+
			"<input type='text' class='form-control' id='phoneNo' name='phoneNo' placeholder=' "+(String)h.get("phoneNo") +"  '></div>");
		  
	out.write("<div class='form-group'>"+
			"<label for='address'>Address:</label>"+
			"<input type='text' class='form-control' id='address' name='address' placeholder=' "+(String)h.get("address") +"  '></div>");
	
	out.write("<div class='form-group'>"+
			"<input type='submit' class='form-control' id='submit' value='UPDATE' ></div>");
	out.write("</form>");
	
	out.write("</div><div class='col-md-3'></div></div>");
	
	System.out.println("reached end of modifyList Servlet");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
