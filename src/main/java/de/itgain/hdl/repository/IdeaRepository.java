package de.itgain.hdl.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import de.itgain.hdl.model.Idea;

public interface IdeaRepository extends ReactiveMongoRepository<Idea, String> {

}
