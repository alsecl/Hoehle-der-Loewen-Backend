package de.itgain.hdl.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.itgain.hdl.model.Idea;
import de.itgain.hdl.repository.IdeaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IdeaService {

	@Autowired
	private IdeaRepository ideaRepository;

	public Mono<Idea> findById(String id) {
		return ideaRepository.findById(id);
	}

	public Flux<Idea> findAll() {
		return ideaRepository.findAll();
	}

	public Flux<Idea> subscribe(Duration delay) {
		return ideaRepository.findAll().delayElements(delay);
	}

	public Mono<Idea> save(Idea idea) {
		return ideaRepository.save(idea);
	}

}
