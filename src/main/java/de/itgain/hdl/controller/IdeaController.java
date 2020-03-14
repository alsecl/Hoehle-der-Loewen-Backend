package de.itgain.hdl.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itgain.hdl.model.Idea;
import de.itgain.hdl.service.IdeaService;
import reactor.core.publisher.Flux;

@CrossOrigin
@RestController
@RequestMapping("/idea")
public class IdeaController {

	private static final int DELAY_TIME_MS = 100;

	@Autowired
	private IdeaService ideaService;

	@GetMapping("/all")
	private Flux<Idea> getAll() {
		return ideaService.findAll();
	}

	@GetMapping("/subscribe")
	private Flux<Idea> sse() {
		return ideaService.subscribe(Duration.ofMillis(DELAY_TIME_MS));
	}

}
