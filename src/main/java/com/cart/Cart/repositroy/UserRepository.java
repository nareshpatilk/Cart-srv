package com.cart.Cart.repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cart.Cart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM public.user u WHERE u.user_email=:userEmail", 
		       nativeQuery = true)
	User findByuserEmail(String userEmail);

	@Query(value = "SELECT * FROM public.user u WHERE u.user_email=:user_email and password=:password", 
		       nativeQuery = true)
	User siginIn(String user_email, String password);
	
}
