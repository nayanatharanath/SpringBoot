package net.training2.kafkaproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import net.training2.kafkaproject.entity.Wikimedia;
import net.training2.kafkaproject.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

	private WikimediaDataRepository dataRepository;

	public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	// private KafkaTemplate<String, String> kafkaTemplate;
	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(String eventMessage) {
		LOGGER.info(String.format("Message received -> %s", eventMessage));

		Wikimedia wikimedia = new Wikimedia();
		wikimedia.setWikiEventData(eventMessage);

		dataRepository.save(wikimedia);
	}

}
