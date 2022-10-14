package app.zainal.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.zainal.com.kafka.KafkaProducer;

@RequestMapping("/api")
@RestController
public class MessageRController {

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("MEssage sent to the Topic");
	}
}
