package de.itgain.hdl.idea;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IdeaRepository extends ReactiveMongoRepository<Idea, String> {

}
