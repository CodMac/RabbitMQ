package zqit.rabbitMQ.pulgins.rabbitMq.fanoutRabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${rbMq.QueueName.fanout.lim}")
public class FanoutReceiverLim {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("FanoutReceiverLim消费者收到消息  : " + msg.toString());
	}
}
