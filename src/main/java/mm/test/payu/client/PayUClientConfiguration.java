package mm.test.payu.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Request;
import feign.slf4j.Slf4jLogger;

@Configuration
public class PayUClientConfiguration {

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Logger logger() {
		return new Slf4jLogger(PayUClient.class);
	}

	@Bean
	public Request.Options requestOptions() {
		return new Request.Options(10000, 10000);
	}

}