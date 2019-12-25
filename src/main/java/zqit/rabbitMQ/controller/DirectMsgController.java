package zqit.rabbitMQ.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test-direct")
@Controller
public class DirectMsgController {

	@Autowired
    RabbitTemplate rabbitTemplate;
	
	@Value("${rbMq.ExchangeName.direct.exchangeMac}")
	private String exchangeMac;

	@GetMapping("/directMsg-mac")
	@ResponseBody
	public String produceDirectMsg4Mac(){
		String msg = "directMsg-mac";
		rabbitTemplate.convertAndSend(exchangeMac, "queue.direct.mac", msg);
		return "directMsg";
	}
	
	
}
