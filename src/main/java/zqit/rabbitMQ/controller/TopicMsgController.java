package zqit.rabbitMQ.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test-topic")
@Controller
public class TopicMsgController {

	@Autowired
    RabbitTemplate rabbitTemplate;
	
	@Value("${rbMq.ExchangeName.topic.exchangeMac}")
	private String exchangeMac;

	@GetMapping("/topicMsg-mac")
	@ResponseBody
	public String produceTopicMsg4Mac(){
		String msg = "topicMsg-mac";
		rabbitTemplate.convertAndSend(exchangeMac, "queue.topic.mac", msg);
		return "topicMsg-mac";
	}
	
	@GetMapping("/topicMsg-who")
	@ResponseBody
	public String produceTopicMsg4Who(){
		String msg = "topicMsg-who";
		rabbitTemplate.convertAndSend(exchangeMac, "queue.topic.who", msg);
		return "topicMsg-who";
	}
	
	
}
