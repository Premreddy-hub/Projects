package com.hcl.ems;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestEms {

	@Test
	public void getEmployLeavesTest() {
		List<Leaves> leaves = EmsBal.getEmployLeavesBal(1000);
		System.out.println(leaves.size());
		for (Leaves leave : leaves) {
			System.out.println(leave.getReason());
		}
	}
	
	

}
