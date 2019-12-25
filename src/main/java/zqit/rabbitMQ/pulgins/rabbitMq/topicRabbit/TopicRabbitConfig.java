package zqit.rabbitMQ.pulgins.rabbitMq.topicRabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

	@Value("${rbMq.QueueName.topic.mac}")
	private String queueMac;
	@Value("${rbMq.QueueName.topic.who}")
	private String queueWho;
	@Value("${rbMq.ExchangeName.topic.exchangeMac}")
	private String exchangeMac;

	@Bean
	public Queue queueMac() {
		return new Queue(queueMac);
	}

	@Bean
	public Queue queueWho() {
		return new Queue(queueWho);
	}

	@Bean
	TopicExchange topicExchangeMac() {
		return new TopicExchange(exchangeMac);
	}

	// 将queueMac和topicExchangeMac绑定,而且绑定的键值为queue.topic.mac
	// 这样只要是消息携带的路由键是queue.topic.mac, 才会分发到该队列
	@Bean
	Binding bindingExchangeMessageMac() {
		return BindingBuilder.bind(queueMac()).to(topicExchangeMac()).with("queue.topic.mac");
	}
	// 将queueMac和topicExchangeMac绑定,而且绑定的键值为queue.topic.#
	// 这样只要是消息携带的路由键是queue.topic.开头, 都会分发到该队列
	@Bean
	Binding bindingExchangeMessageWho() {
		return BindingBuilder.bind(queueWho()).to(topicExchangeMac()).with("queue.topic.#");
	}

}
