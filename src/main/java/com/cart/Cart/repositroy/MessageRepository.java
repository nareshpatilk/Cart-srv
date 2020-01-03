package com.cart.Cart.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cart.Cart.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
