package de.itgain.hdl.idea;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/idea")
public class IdeaController {

	private static final int DELAY_TIME_MS = 100;

	@Autowired
	private IdeaRepository ideaRepository;

	@GetMapping("/{id}")
	private Mono<Idea> getIdeaById(@PathVariable String id) {
		return ideaRepository.findById(id);
	}

	@GetMapping("/all")
	private Flux<Idea> getAll() {
		return ideaRepository.findAll().delayElements(Duration.ofMillis(DELAY_TIME_MS));
	}

	@PostMapping("/save")
	private Mono<Idea> save(@RequestBody Idea idea) {
		return ideaRepository.save(idea);
	}

}
