package de.itgain.hdl.user;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class UserDataProvider implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	private static final Logger log = LoggerFactory.getLogger(UserDataProvider.class);

	@Override
	public void run(String... args) throws Exception {
		saveUserIfNotExists("alexander.clauss@itgain.de", "itgain123", false);
		saveUserIfNotExists("lea.brauner@itgain.de", "test", false);
		saveUserIfNotExists("admin@hdl.de", "test", true);
	}

	private void saveUserIfNotExists(String email, String password, boolean privileged) {
		var exists = userRepository.exists(createExample(email)).block().booleanValue();

		if (!exists) {
			var result = userRepository.save(new User(UUID.randomUUID().toString(), email, password, privileged));

			log.info("Saved user {}", result.block().getEmail());
		} else {
			log.info("{} already saved in DB.", email);
		}
	}

	private Example<User> createExample(String email) {
		var user = new User();
		user.setEmail(email);
		return Example.of(user);
	}

}
