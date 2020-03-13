package de.itgain.hdl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itgain.hdl.event.CreatePollEvent;
import de.itgain.hdl.event.VoteEvent;
import de.itgain.hdl.model.Idea;
import de.itgain.hdl.service.PollService;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/poll")
public class PollController {

	@Autowired
	private PollService pollService;

	@PostMapping("/start")
	private Mono<Idea> create(@RequestBody CreatePollEvent event) {
		return pollService.create(event.getIdeaId(), event.getDurationInMinutes());
	}

	@PostMapping("/vote")
	private Mono<Idea> vote(@RequestBody VoteEvent event) {
		return pollService.vote(event.getIdeaId(), event.getUserId(), event.getRating());
	}

}
