package zqit.rabbitMQ.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test-fanout")
@Controller
public class FanoutMsgController {

	@Autowired
    RabbitTemplate rabbitTemplate;
	
	@Value("${rbMq.ExchangeName.fanout.exchangeMac}")
	private String exchangeMac;

	@GetMapping("/fanoutMsg-mac")
	@ResponseBody
	public String produceFanoutMsg4Mac(){
		String msg = "fanoutMsg-mac";
		rabbitTemplate.convertAndSend(exchangeMac, "queue.fanout.haha", msg);
		return "fanoutMsg-mac";
	}
	
	
}
