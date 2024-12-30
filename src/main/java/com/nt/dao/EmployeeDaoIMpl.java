package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empdao")
public  class EmployeeDaoIMpl implements IEmployeeDao {

	private static final String GET_BY_EMP_DESGS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMPLOYEE";
			//WHERE "
			//+ "JOB in (?,?,?)ORDER BY JOB";
	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> showAllEmployessByDesg(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> list = null;
		
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(GET_BY_EMP_DESGS);
				){
			//set values to Query params
			/*
			 * ps.setString(1, desg1); ps.setString(2, desg2); ps.setString(3, desg3);
			 */
			//execute the query
			try (ResultSet rs = ps.executeQuery())
			{
				list = new ArrayList<Employee>();
				while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				emp.setDeptno(rs.getInt(5));
				//Add all the emp to list
				list.add(emp);
				}// end of while
			} // end of try
		}//end of try
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}//method

} //end of the class
