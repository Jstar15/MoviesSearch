<%@page import="Servlets.SearchServlet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 
<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<title>E-pp</title>
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
		
		<div id="middlebodytitle2">
		    <h3 id="last">© 2013 WoodzMoviez  - For Education Purposes Only</h3>
		</div>


	</div>
	

	
</body>
</html>