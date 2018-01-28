package mm.test.payu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mm.test.payu.client.PayUClient;
import mm.test.payu.support.OrderCreateRequest;
import mm.test.payu.support.OrderCreateResponse;

@RestController
public class PayUController {

	@Autowired
	private PayUClient payUClient;

	@RequestMapping(value = "/order/create", method = RequestMethod.POST)
	public ResponseEntity<OrderCreateResponse> createOrder(@RequestHeader("Authorization") String auth,
			@RequestBody OrderCreateRequest order) {
		return payUClient.createOrder(auth, order);
	}

}