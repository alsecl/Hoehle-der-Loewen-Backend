package de.itgain.hdl.poll;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PollRepository extends ReactiveMongoRepository<Poll, String> {

}
