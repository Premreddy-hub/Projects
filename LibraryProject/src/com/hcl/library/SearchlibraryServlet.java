package com.hcl.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchlibraryServlet
 */
public class SearchlibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchlibraryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		String text=request.getParameter("text");
		HttpSession session = request.getSession(true);
		  String user=(String)session.getAttribute("user");
		List<Library> objLib=LibraryBAL.searchLibraryBal(text, type);
		PrintWriter out=response.getWriter();
		
	    out.println("<form method='get' action='IssueServlet'>");
	    out.println(" welcome : "+user);
		out.println("<table border='6'>");
		out.println("<tr><th>Book Id</th><th>Author Name</th><th>Book Name  </th>");
		out.println("<th>Department</th><th>Edition </th><th>TotalBooks</th><th>Issue</th></tr>");		
		if(objLib!=null){
			for(Library i : objLib){
				out.println("<tr><td>"+i.getId()+"</td>");
				out.println("<td>"+i.getAuthorname()+"</td>");
				out.println("<td>"+i.getBookname()+"</td>");
				out.println("<td>"+i.getDept()+"</td>");
				out.println("<td>"+i.getEdition()+"</td>");
				out.println("<td>"+i.getTotalBooks()+"</td>");
				out.write("<td><input type='checkbox' name='id' value="+i.getId()+"/>");
			
			}
			}else {
				out.println("***NOT AVAILABLE***");
			}
		out.println("<center>Issue Book: <input type='submit' value='lend' "
				+ "</center></form>");
		
	}
			/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
