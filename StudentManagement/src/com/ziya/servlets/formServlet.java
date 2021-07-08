package com.ziya.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.text.SimpleDateFormat;


public class formServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
		String Fname=req.getParameter("fname");
		String Lname=req.getParameter("lname");
		String email=req.getParameter("Email");
		String course=req.getParameter("Course");
		
		String dob=req.getParameter("dob");
			
	
	
		
		String mgender=req.getParameter("male");
		String fgender=req.getParameter("female");
		String mobile=req.getParameter("mobile");
		String gender=null;
		PrintWriter out=res.getWriter();
		
		if(mgender.equals("male")||fgender.equals("female"))
		{
		if(mgender.equals("male"))
		{
			gender=mgender;
		}
		else
		{
			gender=fgender;
		}
		}
		
		else
		{
			out.print("please choose Gender");
		}
		
		out.print("Welcome"+Fname);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_form","root","");
			 String qry="insert into cdata(Fname,Lname,Email,Course,DOB,Gender,Mobile)values('"+Fname+"','"+Lname+"','"+email+"','"+course+"','"+dob+"','"+gender+"','"+mobile+"')";
			 Statement st=con.createStatement();
			 st.execute(qry);
			 System.out.println("creared raw..");
			 RequestDispatcher rd=req.getRequestDispatcher("Validate.html");
				rd.forward(req,res);
				out.print("<h1>Registration successfully</h1>");
			}
		catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
		finally{
		             System.out.println("creared raw..");
		}
	
	}
	


}
