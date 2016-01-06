<%@page import="Servlets.SearchServlet"%>
<%@page import="Webservices.SearchObject"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<% String searchquery =  (String) session.getAttribute("searchquery");%>

<% ArrayList<SearchObject> results = (ArrayList<SearchObject>) session.getAttribute("results"); %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<title>WoodZMovieZ</title>
</head>

<body>
		<div id="header">
		<h3>WoodZMovieZ</h3>
			<div class="menu">
				<ul>
					<li><a href="index.jsp">Home</a></li>
				
				</ul>
			</div>
		</div>    
			
	<div id="main_container">
		<form action="SearchServlet" method="post" class="search">
			<fieldset>
				<ol>
					<li><input type="text" name="searchquery" id="thesearchbox" /></li>					
					<li><input type="submit" value="Search" id="thesearchbutton" /></li>
				</ol>
			</fieldset>
		</form>
		<div id="middlebodytitle">
			<h2>Search Results:<%=searchquery%></h2>
		</div>
		
		<%String tropen  = "<tr>";%>
		<%String trclose  = "<tr>";%>
		
		
		<div id="middlebody">
		<table>	
				<tr>
				
				<%if(searchquery != null){
					for (int i = 0; i < results.size(); i+=2){%>
				        <%=tropen%>
					    <%=results.get(i).ObjectToHtml()%>
				
					    <%if (results.size() % 2 == 0){%>
					        <%=results.get(i+1).ObjectToHtml()%>
					    <%}%>
					<%=trclose%>
				    <%}
				}else{
					 response.sendRedirect("index.jsp");
				}%>
				

				</tr>
		</table>	
		</div>
	</div>
	
</body>
</html>