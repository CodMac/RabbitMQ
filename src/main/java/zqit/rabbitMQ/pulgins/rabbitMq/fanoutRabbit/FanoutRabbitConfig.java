package zqit.rabbitMQ.pulgins.rabbitMq.fanoutRabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

	@Value("${rbMq.QueueName.fanout.mac}")
	private String fanoutQueueMac;
	@Value("${rbMq.QueueName.fanout.lim}")
	private String fanoutQueueLim;
	@Value("${rbMq.QueueName.fanout.who}")
	private String fanoutQueueWho;
	@Value("${rbMq.ExchangeName.fanout.exchangeMac}")
	private String exchangeMac;

	@Bean
	public Queue fanoutQueueMac() {
		return new Queue(fanoutQueueMac, true);
	}
	@Bean
	public Queue fanoutQueueLim() {
		return new Queue(fanoutQueueLim, true);
	}
	@Bean
	public Queue fanoutQueueWho() {
		return new Queue(fanoutQueueWho, true);
	}

	@Bean
	FanoutExchange fanoutExchangeMac() {
		return new FanoutExchange(exchangeMac);
	}

	@Bean
	Binding bindingFanoutWho() {
		return BindingBuilder.bind(fanoutQueueWho()).to(fanoutExchangeMac());
	}
	@Bean
	Binding bindingFanoutMac() {
		return BindingBuilder.bind(fanoutQueueMac()).to(fanoutExchangeMac());
	}
	@Bean
	Binding bindingFanoutLim() {
		return BindingBuilder.bind(fanoutQueueLim()).to(fanoutExchangeMac());
	}
}
