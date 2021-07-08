package com.ziya.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class AccontServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
		//String name=req.getParameter("Username");
		//String email=req.getParameter("Email");
		
		PrintWriter out=res.getWriter();
		Cookie ck[]=req.getCookies();
		String nm=ck[0].getValue();
		String eml=ck[0].getName();
		out.print("Welcome"+nm);
		out.print("this is:"+eml);
	
	}


}
