package net.tarining1.kafkaservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import net.tarining1.kafkaservice.payload.User;

public class JsonKafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

	@KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(User user) {

		LOGGER.info(String.format("JSON message received -> %s", user.toString()));
	}
}
