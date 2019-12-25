package zqit.rabbitMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:zqit/rabbitMQ/pulgins/rabbitMq/mq-queue.properties", encoding = "utf-8")

@SpringBootApplication
public class App extends SpringBootServletInitializer //需要打包为war时， 继承SpringBootServletInitializer，同时重写configure方法
{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
