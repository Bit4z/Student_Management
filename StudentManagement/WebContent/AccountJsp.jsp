<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   cookies = request.getCookies();
  
         cookie = cookies[0];
         String name=cookie.getName( );
         String email=cookie.getValue( );
         out.print("Name : " + name + ",  ");
         out.print("Value: " + email+" <br/>");
         cookie.setMaxAge(0);
         response.addCookie(cookie);
      
 
%>
<%
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_form","root","");
	Statement st=con.createStatement();
	String fd1="select *from cdata";
	ResultSet rs1=st.executeQuery(fd1);
	while(rs1.next())
	{	
		String n;
		n=rs1.getString(1);
		String p;
		p=rs1.getString(3);
		if(n.equals(name)&&p.equals(email))
		{
			n=rs1.getString(1);
			String ln=rs1.getString(2);
			String em=rs1.getString(3);
			String crs=rs1.getString(4);
			String db=rs1.getString(5);
			String gdr=rs1.getString(6);
			String mb=rs1.getString(7);
			out.print("First Name:"+n+"<br>");
			out.print("Last Name"+ln+"<br>");
			out.print("Email"+em+"<br>");
			out.print("Course"+crs+"<br>");
			out.print("DOB"+db+"<br>");
			out.print("Gender"+gdr+"<br>");
			out.print("Mobile No:"+mb+"<br>");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Index.html");
			out.print("Invalis user or Password");
		}

	}

}



catch(Exception e)
{
	out.print(e.getMessage());
}

%>

</body>
</html>