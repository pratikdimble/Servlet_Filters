package com.pratik.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

		}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
										throws IOException, ServletException {
			
		String id_Error = "",
				name_Error = "", 
					age_Error = "", 
						email_Error = "", 
							mobile_Error = "";
		try {
			response.setContentType("text/html");
				PrintWriter out = response.getWriter();

					String id = request.getParameter("id");
					String name = request.getParameter("name");
					String sage = request.getParameter("age");
					String email = request.getParameter("email");
					String mobile = request.getParameter("mobile");

					boolean flag = true;
						if(id == null || id.equals("")) {
							id_Error = "id is Required.";
					flag = false;
						}else {
							if(!id.startsWith("PS-")) {
								id_Error = "id is Invalid, id must be PS-<number>.";
								flag = false;
							}
						}
						if(name == null || name.equals("")) {
							name_Error = "name is Required.";
							flag = false;
						}
						if(sage == null || sage.equals("")) {
							age_Error = "age is Required.";
							flag = false;
						}else {
							int age = Integer.parseInt(sage);
							if(age < 18) {
								age_Error = "age must not be less than 18 Years."; 
								flag = false;
							}
							if(age > 30) {
								age_Error = "age must not be greater than 30 Years.";
								flag = false;
							}
						}
						if(email == null || email.equals("")) {
							email_Error = "email is Required.";
							flag = false;
						}else {
							if(!email.endsWith("@pratiksoft.com")) {
								email_Error = "email is Invalid Email ID ends with @pratiksoft.com.";
								flag = false;
							}
						}
						
						if(mobile == null || mobile.equals("")) {
							mobile_Error = "mobile is Required.";
							flag = false;
						}else {
							if(!mobile.startsWith("91-")) {
								mobile_Error = "mobile is Invalid Mobile Number starts with 91-<number>.";
								flag = false;
							}
						}
						
						if(flag == true) {
							chain.doFilter(request, response);
						}else {
							out.println("<html>");
							out.println("<body>");
							out.println("<h2>Pratik Softwares</h2>");
							out.println("<h3>Student Registration Form</h3>");
							out.println("<form method='POST' action='./reg'>");
							out.println("<table>");
							out.println("<tr>");
							out.println("<td>Student Id</td>");
							out.println("<td><input type='text' name='id' value='"+id+"'/></td>");
							out.println("<td><font color='red' size='5'><b>"+id_Error+"</b></font></td>");
							out.println("</tr>");
							
							out.println("<tr>");
							out.println("<td>Student Name</td>");
							out.println("<td><input type='text' name='name' value='"+name+"'/></td>");
							out.println("<td><font color='red' size='5'><b>"+name_Error+"</b></font></td>");
							out.println("</tr>");
							
							out.println("<tr>");
							out.println("<td>Student Age</td>");
							out.println("<td><input type='text' name='age' value='"+sage+"'/></td>");
							out.println("<td><font color='red' size='5'><b>"+age_Error+"</b></font></td>");
							out.println("</tr>");
							
							out.println("<tr>");
							out.println("<td>Student Email</td>");
							out.println("<td><input type='text' name='email' value='"+email+"'/></td>");
							out.println("<td><font color='red' size='5'><b>"+email_Error+"</b></font></td>");
							out.println("</tr>");
							
							out.println("<tr>");
							out.println("<td>Student Mobile</td>");
							out.println("<td><input type='text' name='mobile' value='"+mobile+"'/></td>");
							out.println("<td><font color='red' size='5'><b>"+mobile_Error+"</b></font></td>");
							out.println("</tr>");
							
							out.println("<tr>");
							out.println("<td><input type='submit' value='Registration'/></td>");
							out.println("</tr>");
							
							out.println("</table></form></body></html>");
						}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void destroy() {
	}
			
}
