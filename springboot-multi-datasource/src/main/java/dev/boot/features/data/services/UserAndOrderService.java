package dev.boot.features.data.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.boot.features.data.user.entities.User;
import dev.boot.features.data.user.repositories.UserRepository;

@Service
public class UserAndOrderService {

	@Autowired
	UserRepository userRepository;

	@Transactional(transactionManager = "userTransactionManager")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
