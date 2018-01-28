package mm.test.payu.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mm.test.payu.support.OrderCreateRequest;
import mm.test.payu.support.OrderCreateResponse;
import mm.test.payu.support.Status;
import mm.test.payu.support.StatusCode;

@Component
public class PayUClientFallback implements PayUClient {

	@Override
	public ResponseEntity<OrderCreateResponse> createOrder(String auth,  OrderCreateRequest order) {
		OrderCreateResponse response = OrderCreateResponse.of(new Status(StatusCode.ERROR_INTERNAL.name()));

		return new ResponseEntity<OrderCreateResponse>(response, HttpStatus.OK);
	}

}