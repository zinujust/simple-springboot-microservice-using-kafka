package app.zainal.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.zainal.com.kafka.JsonKafkaProducer;
import app.zainal.com.model.User;

@RequestMapping("/api")
@RestController
public class JsonMessageControler {

	
	@Autowired
	private JsonKafkaProducer producer;
	
	@PostMapping("/send")
	public ResponseEntity<String> publish(@RequestBody User user){
		producer.sendMessage(user);
		
		return ResponseEntity.ok("JSON message send to kafka topic");
	}
}
