package app.zainal.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	
		private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
		
	
	@KafkaListener(topics = "javaguides_json", groupId = "myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
	}
}
