package de.itgain.hdl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itgain.hdl.request.AuthenticateUserRequest;
import de.itgain.hdl.response.UserAuthenticationResponse;
import de.itgain.hdl.service.UserService;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	private Mono<UserAuthenticationResponse> login(@RequestBody AuthenticateUserRequest request) {
		return userService.findByCredentials(request.getEmail(), request.getPassword())
				.map(u -> new UserAuthenticationResponse(u))
				.onErrorResume(e -> Mono.just(new UserAuthenticationResponse(e.getMessage())));
	}

}
