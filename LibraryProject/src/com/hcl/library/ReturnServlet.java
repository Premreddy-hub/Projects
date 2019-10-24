package com.hcl.library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReturnServlet
 */
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Connection con=DaoConnection.getConnection();
		ResultSet rs = null;
		  String user=(String)session.getAttribute("username");
		  String cmd = "select * from tranbook where username = ?";
		  PrintWriter out = response.getWriter();
		  try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setString(1, user);
			rs = pst.executeQuery();
			 out.print("<table><tr><td>book Id</td><td>From Date</td><td>To date</td></tr>");
			while(rs.next()){ 
				 out.print("<tr><td>"+rs.getInt("bookid")+"</td><td>"+rs.getString("fromdate")+"</td><td>"+rs.getString("todate")+"</td></tr> ");
				 out.print("</table>");
				/* out.print("");
				 out.print("");
				 out.print("");
				 out.print("");
				 out.print("");*/
				
				//out.println(LibraryBAL.ReturnLibraryBal(id, username));
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				  
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
