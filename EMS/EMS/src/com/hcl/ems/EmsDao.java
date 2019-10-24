package com.hcl.ems;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmsDao {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	String cmd="";
	
	public boolean loginDao(int ID, String passWord) {
			String cmd = "select EMP_ID from EmployLogin where EMP_ID =? and SecretCode=?;";
			con = DaoConnection.getConnection();
			
			boolean result = false;
			try {
				pst =  con.prepareStatement(cmd);
				pst.setInt(1, ID);
				pst.setString(2, passWord);
				rs = pst.executeQuery();
				if(rs.next()) {
					result = true;
				} 
			} catch (Exception e) {
			}
			return result;	
		}

	public Employ getAccountInfoDao(Integer ID) {

		cmd = "select * from EMPLOYEE where EMP_ID = ?";
		con = DaoConnection.getConnection();
		Employ e = null;
		try {
			pst = con.prepareStatement(cmd);
			pst.setInt(1, ID);
			rs = pst.executeQuery();
			if(rs.next()){
				e = new Employ();
				e.setEmpId(ID);
				e.setEmpName(rs.getString("EMP_NAME"));
				e.setEmpMail(rs.getString("EMP_EMAIL"));
				e.setEmpMobNo(rs.getBigDecimal("EMP_MOB_NO"));
				e.setEmpDateJoined(rs.getDate("EMP_DATE_JOINED"));
				e.setEmpDpeName(rs.getString("EMP_DPT_NAME"));
				e.setEmpLeaveBalance(rs.getInt("EMP_LEAVE_BALANCE"));
				e.setEmpMgrId(rs.getInt("EMP_MGR_ID"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return e;
		
	}
    
	public String applyLeaveDao(Leaves leave)  {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String stDate=sdf.format(leave.getStartDate());
		String endDate=sdf.format(leave.getEndDate());
		LeaveTypes lt=LeaveTypes.EL;
		java.util.Date dt=new java.util.Date();
		String leavAppliedOn=sdf.format(dt);
		Employ l=EmsBal.getAccountInfoBal(leave.getEmpId());
		LeaveStatus ls;
		if(l.getEmpMgrId() == 0) {
			 ls=LeaveStatus.APPROVED;
		}  else {
			ls=LeaveStatus.PENDING;
		}
		String result="";
		if(l.getEmpLeaveBalance() > 0) {
			
		
		String cmd="Insert into Leave_History(LEA_START_DATE,LEA_END_DATE,LEA_NO_OF_DAYS,LEA_REASON,"
				+ "LEA_TYPE,LEA_APPLIED_ON,EMP_ID,LEA_STATUS) VALUES(?,?,?,?,?,?,?,?)";
		Connection con=DaoConnection.getConnection();
		
		try {
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setString(1, stDate);
			pst.setString(2, endDate); 
			pst.setInt(3, leave.getNoDays());
			pst.setString(4, leave.getReason());
			pst.setString(5, lt.toString());
			pst.setString(6, leavAppliedOn);
			pst.setInt(7, leave.getEmpId()); 
			pst.setString(8, ls.toString());
			pst.executeUpdate();
			result="Leave Applied Successfully...";
			cmd = "update employee set EMP_LEAVE_BALANCE = EMP_LEAVE_BALANCE - 1 where EMP_ID =?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1,leave.getEmpId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			result=e.getMessage();
		}
		} else {
			result = "Insufficient Leave Balance";
		}
		return result;
	}

	public Leaves getMyLeavesDao(int empId) {
		cmd = "select * from leave_history where EMP_ID =?;";
		con = DaoConnection.getConnection();
		Leaves l = new Leaves();
		try {
			pst = con.prepareStatement(cmd);
			pst.setInt(1, empId);
			rs = pst.executeQuery();
			if(rs.next()) {
				
				l.setEmpId(empId);
				l.setStartDate(rs.getDate("LEA_START_DATE"));
				l.setEndDate(rs.getDate("LEA_END_DATE"));
				l.setNoDays(rs.getInt("LEA_NO_OF_DAYS"));
				l.setLeaId(rs.getInt("LEA_ID"));
				l.setType(rs.getString("LEA_TYPE"));
				l.setStatus(rs.getString("LEA_STATUS"));
				l.setReason(rs.getString("LEA_REASON"));
				l.setAppliedOn(rs.getDate("LEA_APPLIED_ON"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;		
	}

	
	public List<Leaves> getEmployLeavesDao(int mgrId) {
		
		
		con = DaoConnection.getConnection();
		List<Leaves> leaves = new ArrayList<Leaves>();
		Leaves leave = null;
		int empId = 0;
		try {
			cmd = "select EMP_ID from employee where EMP_MGR_ID = ?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, mgrId);
			rs = pst.executeQuery();
			while(rs.next()){
				empId = rs.getInt("EMP_ID");
				leave = EmsBal.getMyLeavesBal(empId);
				leaves.add(leave);
			}		
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return leaves;
	}
}
