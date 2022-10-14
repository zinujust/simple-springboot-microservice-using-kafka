package app.zainal.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import app.zainal.com.model.User;

@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

	private KafkaTemplate<String, User> kt;

	public JsonKafkaProducer(KafkaTemplate<String, User> kt) {
		this.kt = kt;
	}
	
	public void sendMessage(User user) {
		
		LOGGER.info(String.format("Message sent -> %s", user.toString()));
		
		Message<User> message = MessageBuilder
				.withPayload(user)
				.setHeader(KafkaHeaders.TOPIC, "javaguides_json")
				.build();
		
		kt.send(message);
	}

}
