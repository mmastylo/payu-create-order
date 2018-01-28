package mm.test.payu;

import com.google.common.collect.Lists;

import mm.test.payu.support.OrderCreateRequest;
import mm.test.payu.support.Product;

public final class OrderFixture {

	private OrderFixture() {

	}

	public static OrderCreateRequest orderCreateRequest() {
		return OrderCreateRequest.of("aa", "aa", "aa", "PLN", "1000", Lists.newArrayList(product()));
	}

	private static Product product() {
		return Product.of("aa", "100", "1");
	}

}