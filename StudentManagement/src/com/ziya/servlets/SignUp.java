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
public class SignUp extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException{
		String name=req.getParameter("username");
		
		String pass=req.getParameter("password");
		PrintWriter out=res.getWriter();
		
		int c=0;
		
		String n="ziya";
		
		String p="123";
		
		
		
		

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
	           Statement st=con.createStatement();
	           
	           String fd1="select *from dTable";
               ResultSet rs1=st.executeQuery(fd1);
          
             while(rs1.next())
             {	
                 //System.out.println(rs1.getString(1)); 
            	
               System.out.println(rs1.getString(1)+":\t"+rs1.getString(3)); 
            	 String nm=rs1.getString(1);
            	 String eml=rs1.getString(2);
            	 String pw=rs1.getString(3);
            	 if(nm.equals(name)&&pw.equals(pass))
            	 {
c=c+1;
Cookie ck=new Cookie(nm,eml);

res.addCookie(ck);



         			RequestDispatcher rd=req.getRequestDispatcher("Main.jsp");
         			rd.forward(req, res);
         			
         			break;
            	 }
             }
             if(c==0)
             {
            	 RequestDispatcher rd1=req.getRequestDispatcher("Validate.html");
     			rd1.include(req, res);
     			out.print("invalid user or password");
             }
			}
		catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
		finally{
			
		             System.out.println("validate3.."+(name.equals(n)+":"+name+":"+pass));
		}
		
	}


}
