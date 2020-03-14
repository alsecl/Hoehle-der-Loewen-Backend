package de.itgain.hdl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itgain.hdl.model.Idea;
import de.itgain.hdl.request.CreatePollRequest;
import de.itgain.hdl.request.VoteRequest;
import de.itgain.hdl.service.PollService;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/poll")
public class PollController {

	@Autowired
	private PollService pollService;

	@PostMapping("/start")
	private Mono<Idea> create(@RequestBody CreatePollRequest request) {
		return pollService.create(request.getIdeaId(), request.getDurationInMinutes());
	}

	@PostMapping("/vote")
	private Mono<Idea> vote(@RequestBody VoteRequest request) {
		return pollService.vote(request.getIdeaId(), request.getUserId(), request.getRating());
	}

}
