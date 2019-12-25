package zqit.rabbitMQ.pulgins.rabbitMq.directRabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitConfig {
	
	@Value("${rbMq.QueueName.direct.mac}")
	private String directQueueMac;
	@Value("${rbMq.ExchangeName.direct.exchangeMac}")
	private String exchangeMac;
	
    @Bean
    public Queue directQueueMac() {
        return new Queue(directQueueMac, true);  //true 是否持久 
    }
    @Bean
    DirectExchange exchangeMac() {
        return new DirectExchange(exchangeMac);
    }
    @Bean
    Binding bindingDirectMac() {
    	//绑定  将队列和交换机绑定, 并设置用于匹配键：queue.direct.mac
        return BindingBuilder.bind(directQueueMac()).to(exchangeMac()).with("直连交互机-无需匹配路由");
    }

}
