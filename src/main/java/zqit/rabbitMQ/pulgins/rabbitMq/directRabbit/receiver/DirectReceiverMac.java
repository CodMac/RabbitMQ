package zqit.rabbitMQ.pulgins.rabbitMq.directRabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rbMq.QueueName.direct.mac}")
public class DirectReceiverMac {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("DirectReceiverMac消费者收到消息  : " + msg.toString());
	}
}
