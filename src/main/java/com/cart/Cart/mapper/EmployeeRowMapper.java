package com.cart.Cart.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.cart.Cart.model.*;

public class EmployeeRowMapper implements RowMapper<Employee>{



@Override
public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	Employee emp = new Employee();
	emp.setEmployeename(rs.getString("employeename"));
	emp.setEmployeeaddress(rs.getString("employeeaddress"));
	emp.setEmployeeemail(rs.getString("employeeemail"));
	return emp;
}
}
