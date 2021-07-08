<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="NewFile.css">
 <script src="myScript.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   cookies = request.getCookies();
   if( cookies != null ){
      for (int i = 0; i < cookies.length-1; i++){//
         cookie = cookies[0];
         out.print( "<div align='right'>"+"Welcome : \n"+ cookie.getName( ) + "</div>"+ ",  ");
        // out.print("Value: " + cookie.getValue( )+" <br/>");
         cookie.setMaxAge(1);
         response.addCookie(cookie);
      }
  }else{
      out.println("<h2>No cookies founds</h2>");
  }
%>
<div id="mySidepanel" class="sidepanel">
  <button class="closebtn" onclick="closeNav()">&times;</button>
  
  <a href="Main.html">Home</a>
  <a href="AccountJsp.jsp">My Acount</a>
  <a href="/khan">Attendance</a>
  <a href="#">My Time Table</a>
  <a href="#">Event</a>
  <a href="#">Hierarchy</a>
  
</div>
<div align="right">


</div>

<button class="openbtn" onclick="openNav()">&#9776; Student Management</button>

<center>
<h1>Chandigarh University</h1>
<hr>
</center>
<img src="C:\Users\ziyaulhaq khan\Desktop\102AK_ST\khan1.jpeg"width="95%" height="600"></img>

</body>
</html>