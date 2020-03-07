package de.itgain.hdl.poll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/poll")
public class PollController {

	@Autowired
	private PollService pollService;

	@GetMapping("/subscribe")
	private Flux<Poll> subscribe() {
		return pollService.subscribe();
	}

	@PostMapping("/start")
	private Mono<Poll> createPoll(@RequestBody CreatePollEvent event) {
		return pollService.create(event.getIdeaId(), event.getDurationInMinutes());
	}

}
