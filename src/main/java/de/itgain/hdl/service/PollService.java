package de.itgain.hdl.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.itgain.hdl.model.Idea;
import de.itgain.hdl.model.Poll;
import de.itgain.hdl.model.Rating;
import reactor.core.publisher.Mono;

@Service
public class PollService {

	@Autowired
	private IdeaService ideaService;

	public Mono<Idea> create(String ideaId, int durationInMinutes) {
		return getIdea(ideaId).flatMap(idea -> {
			idea.setPoll(new Poll(ideaId, Duration.ofMinutes(durationInMinutes)));

			return Mono.just(idea);
		});
	}

	public Mono<Idea> start(String ideaId) {
		return getIdea(ideaId).flatMap(this::schedulePoll);
	}

	private Mono<Idea> schedulePoll(Idea idea) {
		int processors = Runtime.getRuntime().availableProcessors();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(processors);

		idea.getPoll().setStartTime(LocalDateTime.now());

		executor.schedule(() -> {
			idea.getPoll().setFinished(true);

			return ideaService.save(idea);
		}, idea.getPoll().getDuration().getSeconds(), TimeUnit.SECONDS);

		return Mono.just(idea);
	}

	private Mono<Idea> getIdea(String id) {
		return ideaService.findById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull);
	}

	public Mono<Idea> vote(String ideaId, String userId, Rating rating) {
		return getIdea(ideaId).flatMap(idea -> {
			if (!idea.getPoll().isFinished()) {
				idea.getPoll().getRatings().put(userId, rating);
			}

			return ideaService.save(idea);
		});
	}

}
