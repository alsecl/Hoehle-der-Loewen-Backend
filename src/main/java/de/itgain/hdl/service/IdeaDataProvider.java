package de.itgain.hdl.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import de.itgain.hdl.model.Idea;
import de.itgain.hdl.repository.IdeaRepository;

@Component
public class IdeaDataProvider implements CommandLineRunner {

	@Autowired
	private IdeaRepository ideaRepository;

	private static final Logger log = LoggerFactory.getLogger(IdeaDataProvider.class);

	@Override
	public void run(String... args) throws Exception {
		var idea1 = createIdea("Idea Title 1", "Idea Author 1", "Lorem Ipsum dolor... 1.");
		var idea2 = createIdea("Idea Title 2", "Idea Author 2", "Lorem Ipsum dolor... 2.");
		var idea3 = createIdea("Idea Title 3", "Idea Author 3", "Lorem Ipsum dolor... 3.");

		saveIdeaIfNotExists(idea1);
		saveIdeaIfNotExists(idea2);
		saveIdeaIfNotExists(idea3);
	}

	private Idea createIdea(String title, String author, String description) {
		var idea = new Idea();

		idea.setId(UUID.randomUUID().toString());
		idea.setTitle(title);
		idea.setAuthor(author);
		idea.setDescription(description);

		return idea;
	}

	private void saveIdeaIfNotExists(Idea idea) {
		var exists = ideaRepository.exists(createExample(idea.getTitle())).block().booleanValue();

		if (!exists) {
			var result = ideaRepository.save(idea);

			log.info("Saved idea {}", result.block().getTitle());
		} else {
			log.info("{} already saved in DB.", idea.getTitle());
		}
	}

	private Example<Idea> createExample(String title) {
		var idea = new Idea();
		idea.setTitle(title);
		return Example.of(idea);
	}

}
