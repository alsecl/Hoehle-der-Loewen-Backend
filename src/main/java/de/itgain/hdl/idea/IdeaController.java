package de.itgain.hdl.idea;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/idea")
public class IdeaController {

	private static final int DELAY_TIME_MS = 100;

	@Autowired
	private IdeaService ideaService;

	@GetMapping("/{id}")
	private Mono<Idea> getIdea(@PathVariable String id) {
		return ideaService.findById(id);
	}

	@GetMapping("/all")
	private Flux<Idea> getAll() {
		return ideaService.findAll();
	}

	@GetMapping("/subscribe")
	private Flux<Idea> sse() {
		return ideaService.subscribe(Duration.ofMillis(DELAY_TIME_MS));
	}

	@PostMapping("/create")
	private Mono<Idea> save(@RequestBody Idea idea) {
		return ideaService.save(idea);
	}

}
