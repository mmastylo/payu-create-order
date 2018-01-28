package mm.test.payu.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mm.test.payu.support.OrderCreateRequest;
import mm.test.payu.support.OrderCreateResponse;

@FeignClient(name = "payu", url = "${payu.api.url}", configuration = PayUClientConfiguration.class, fallback = PayUClientFallback.class)
public interface PayUClient {

	@RequestMapping(value = "/api/v2_1/orders", method = RequestMethod.POST)
	ResponseEntity<OrderCreateResponse> createOrder(@RequestHeader("Authorization") String auth,
			@RequestBody OrderCreateRequest order);

}