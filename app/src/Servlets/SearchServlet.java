//Created By Jordan Waddell
package Servlets;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Webservices.SearchMovie;
import Webservices.SearchObject;


//checks username authenticity is passed the redirects user noect page
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

	
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {	
	 String searchquery = request.getParameter("searchquery");
	 request.getSession().setAttribute("searchquery", searchquery );
	 
	 SearchMovie searchmovie = new SearchMovie(searchquery);
	 ArrayList<SearchObject> results = searchmovie.getSearcharray();
	 request.getSession().setAttribute("results", results );
	 
	 response.sendRedirect("search.jsp");
	 
}

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	 processRequest(request, response);
}
@Override
public String getServletInfo() {
	 return "Short description";
}
}