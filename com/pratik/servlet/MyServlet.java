package com.pratik.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String sage=(request.getParameter("sage"));
			//int sage = Integer.parseInt(request.getParameter("sage"));
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
	out.println("<html>");
		out.println("<body>");
			out.println("<h2>Pratik Softwares</h2>");
			out.println("<h3>Student Registration Details</h3>");
				out.println("<table border='1'>");
					out.println("<tr><td>Student Id</td><td>"+id+"</td></tr>");
						out.println("<tr><td>Student Name</td><td>"+name+"</td></tr>");
						out.println("<tr><td>Student Age</td><td>"+sage+"</td></tr>");
						out.println("<tr><td>Student Email</td><td>"+email+"</td></tr>");
						out.println("<tr><td>Student Mobile</td><td>"+mobile+"</td></tr>");
				out.println("</table></body></html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
