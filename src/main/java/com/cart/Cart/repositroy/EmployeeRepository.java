package com.cart.Cart.repositroy;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cart.Cart.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findByemployeeid(String string);
	
	@Query(value = "SELECT employeeaddress FROM public.employee u WHERE u.employeeaddress like %?1%", 
		       nativeQuery = true)
	List<String> findByEmployeeaddressContaining(String employeeaddress);
}
