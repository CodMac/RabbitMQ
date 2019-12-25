package zqit.rabbitMQ.pulgins.rabbitMq.topicRabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rbMq.QueueName.topic.mac}")
public class TopicReceiverMac {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("TopicReceiverMac消费者收到消息  : " + msg.toString());
	}
}
