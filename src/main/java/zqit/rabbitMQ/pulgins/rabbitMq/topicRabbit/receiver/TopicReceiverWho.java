package zqit.rabbitMQ.pulgins.rabbitMq.topicRabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rbMq.QueueName.topic.who}")
public class TopicReceiverWho {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("TopicReceiverWho消费者收到消息  : " + msg.toString());
	}
}
