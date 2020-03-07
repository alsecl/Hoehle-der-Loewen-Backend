package de.itgain.hdl.poll;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.itgain.hdl.idea.IdeaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PollService {

	@Autowired
	private PollRepository pollRepository;

	@Autowired
	private IdeaService ideaService;

	public Mono<Poll> create(String ideaId, int durationInMinutes) {
		return pollRepository.save(new Poll(ideaId, Duration.ofMinutes(durationInMinutes)));
	}

	public Mono<Poll> start(String pollId) {
		return pollRepository.findById(pollId).switchIfEmpty(Mono.empty()).filter(Objects::nonNull)
				.flatMap(this::schedulePoll);
	}

	public Flux<Poll> subscribe() {
		return pollRepository.findAll().delayElements(Duration.ofMillis(100));
	}

	private Mono<Poll> schedulePoll(Poll poll) {
		int processors = Runtime.getRuntime().availableProcessors();
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(processors);

		poll.setStartTime(LocalDateTime.now());

		executor.schedule(() -> {
			ideaService.setRating(poll);
			pollRepository.delete(poll);
		}, poll.getDuration().getSeconds(), TimeUnit.SECONDS);

		return pollRepository.save(poll);
	}

}
