package com.cart.Cart.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cart.Cart.model.User;
import com.cart.Cart.repositroy.UserRepository;

@Service
public class UserService implements UserRepository {

	
	@Autowired
	UserRepository userRepo;
	
	org.jboss.logging.Logger logger = LoggerFactory.logger(this.getClass());

	
	@Override
	public User findByuserEmail(String userEmail) {
		
		return userRepo.findByuserEmail(userEmail);
	}
	
	@Transactional
	public long saveUser(User user) {
		
		try {
			
			User existingUser =  (User) findByuserEmail(user.getUserEmail());
			if(existingUser == null) {
				
				User newUser = userRepo.save(user);
				logger.info("User created successfully {{user create service}} user id " +newUser.getUserId());
				return newUser.getUserId();
				
			}else {
				logger.info("User already exists {{user create service}}");
				return 0;
			}
			
			
		}catch (Exception e) {
			logger.error("User already exists {{user create service})"+ e.getMessage());
		}
		
		return 0;
		
	}
	
	public User siginInCheck(User userCheck) {
		User user = null;
		try {
			user = siginIn(userCheck.getUserEmail(), userCheck.getPassword());
			if(user == null) {
				logger.info("User signin successfully {{user service}} user id " +user.getUserId());
				return user;
			}else {
				logger.info("User not exists {{user service}}");
				return user;
			}
		}catch (Exception e) {
			logger.error("User already exists {{user service})"+ e.getMessage());
		}
		return user;
	}

	@Override
	public User siginIn(String userEmail, String password) {
		return userRepo.siginIn(userEmail, password);
	}
	
	@Override
	public <S extends User> S save(S entity) {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	@Override
	public List<User> findAll() {
		
		return null;
	}

	@Override
	public List<User> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends User> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends User> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends User> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
