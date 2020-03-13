package de.itgain.hdl.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import de.itgain.hdl.model.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

}
