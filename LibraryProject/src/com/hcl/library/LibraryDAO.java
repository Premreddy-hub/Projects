package com.hcl.library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class LibraryDAO {
	PreparedStatement pst = null;
	Connection con = null;
	ResultSet rs = null;
	public List<Library> SearchLibrary(String text,String type ) {
		List<Library> list=new ArrayList();
		Library objLib= null;
		con=DaoConnection.getConnection();
		if(type.equals("id")){
			String cmd="select *from books where id=?";
			try {
				pst=con.prepareStatement(cmd);
				pst.setInt(1, Integer.parseInt(text));
				rs= pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(type.equals("dept")){
			String cmd="select *from books where dept=?";
			try {
				pst=con.prepareStatement(cmd);
				pst.setString(1, text);
				rs= pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(type.equals("authorname")){
			String cmd="select *from books where author=?";
			try {
				pst=con.prepareStatement(cmd);
				pst.setString(1, text);
				 rs= pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(type.equals("bookname")){
			String cmd="select *from books where name=?";
			try {
				pst=con.prepareStatement(cmd);
				pst.setString(1, text);
				 rs= pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(type.equals("all")){
			String cmd="select *from books";
			try {
				pst=con.prepareStatement(cmd);
				 rs= pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			while(rs.next()){
				Library ob = new Library();
				ob.setId(rs.getInt("id"));
				ob.setAuthorname(rs.getString("author"));
				ob.setBookname(rs.getString("name"));
				ob.setDept(rs.getString("dept"));
				ob.setEdition(rs.getString("edition"));
				ob.setTotalBooks(rs.getInt("TotalBooks"));
				list.add(ob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public String  IssueLibrary(String[] id,String username ) {
		con=DaoConnection.getConnection();
		for(String i : id){
			String cmd="select count(*) count from tranbook where username=? and bookid =?";
			String result= null;
			try {
				pst=con.prepareStatement(cmd);
				pst.setString(1, username);
				pst.setInt(2, Integer.parseInt(i.substring(0,2)));
				rs=pst.executeQuery();
				rs.next();
				if(rs.getInt("count")!=0){
					return "Book Already Borrowed";
				}
				else{
					cmd="update books set totalbooks=totalbooks-1 where id=?";
			        pst=con.prepareStatement(cmd);
					pst.setInt(1, Integer.parseInt(i.substring(0,2)));
				    pst.executeUpdate();
				    cmd="insert into tranbook(username,bookid) values(?,?)";
				    pst=con.prepareStatement(cmd);
				    pst.setString(1, username);
				    pst.setInt(2, Integer.parseInt(i.substring(0,2)));
				    pst.executeUpdate();
				    
				    return  "Successfully borrowed";
				}
			}catch (SQLException e) {
				e.printStackTrace();
			} 
		} return "please select the books";
	}
	public String ReturnLibraryDao(String[]  id,String username) {
			con=DaoConnection.getConnection();
			for(String i : id){
				try {
						
					String cmd="select fromdate from tranbook where bookid = ? and username = ?";
			        pst=con.prepareStatement(cmd);
			        pst.setString(2, username);
					pst.setInt(1, Integer.parseInt(i.substring(0,2)));
					ResultSet rs = pst.executeQuery();
					rs.next();
					
						cmd="insert into transreturn(username,bookid,fromdate) values(?,?,?)";
				        pst=con.prepareStatement(cmd);
				        pst.setString(1, username);
						pst.setInt(2, Integer.parseInt(i.substring(0,2)));
						pst.setString(3, rs.getString("fromdate"));
					    pst.executeUpdate();
					    
					    
				       cmd="update books set totalbooks=totalbooks+1 where id=?";
				        pst=con.prepareStatement(cmd);
						pst.setInt(1, Integer.parseInt(i.substring(0,2)));
					    pst.executeUpdate();
					    
					    
					    cmd="delete from tranbook where id=? and username=?";
					    pst=con.prepareStatement(cmd);
					    pst.setString(2, username);
					    pst.setInt(1, Integer.parseInt(i.substring(0,2)));
					    pst.executeUpdate();
					    
					  
					}	catch (SQLException e) {
					e.printStackTrace();
				} 
			}  return  "Successfully returned";
	}
}

	



