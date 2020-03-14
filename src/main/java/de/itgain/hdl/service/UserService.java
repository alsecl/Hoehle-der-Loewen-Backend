package de.itgain.hdl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import de.itgain.hdl.model.User;
import de.itgain.hdl.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Mono<User> findByCredentials(String email, String password) {
		User user = new User();

		user.setEmail(email);
		user.setPassword(password);

		return userRepository.findOne(Example.of(user));
	}

}
