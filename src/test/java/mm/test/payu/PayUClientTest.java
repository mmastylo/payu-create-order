package mm.test.payu;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.springframework.util.StreamUtils;

import com.github.tomakehurst.wiremock.common.Slf4jNotifier;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;

import mm.test.payu.client.PayUClient;
import mm.test.payu.support.OrderCreateResponse;
import mm.test.payu.support.StatusCode;

@RunWith(SpringRunner.class)
@SpringBootTest()
@ContextConfiguration(initializers = PayUClientTest.RandomPortInitializer.class)
public class PayUClientTest {

	private static final String AUTH_MOCK = "auth";

	@Autowired
	public PayUClient payUClient;

	@ClassRule
	public static WireMockClassRule wiremock = new WireMockClassRule(
			wireMockConfig().dynamicPort().notifier(new Slf4jNotifier(true)));

	@Test
	public void testCreateOrder() throws IOException {
		stubFor(post(urlEqualTo("/api/v2_1/orders")) //
				.willReturn(aResponse() //
						.withStatus(HttpStatus.OK.value()) //
						.withHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE) //
						.withBody(StreamUtils.copyToString(
								getClass().getClassLoader().getResourceAsStream("fixtures/OrderCreateResponse.json"),
								Charset.forName("UTF-8")))));

		ResponseEntity<OrderCreateResponse> entity = payUClient.createOrder(AUTH_MOCK,
				OrderFixture.orderCreateRequest());
		OrderCreateResponse response = entity.getBody();

		assertNotNull(response);
		assertEquals(StatusCode.SUCCESS.name(), response.getStatus().getStatusCode());
	}

	@Test
	public void testCreateOrderFallback() throws IOException {
		stubFor(post(urlEqualTo("/api/v2_1/orders")) //
				.willReturn(aResponse() //
						.withFixedDelay(5000)));

		ResponseEntity<OrderCreateResponse> entity = payUClient.createOrder(AUTH_MOCK,
				OrderFixture.orderCreateRequest());
		OrderCreateResponse response = entity.getBody();

		assertNotNull(response);
		assertEquals(StatusCode.ERROR_INTERNAL.name(), response.getStatus().getStatusCode());
	}

	public static class RandomPortInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

		@Override
		public void initialize(ConfigurableApplicationContext applicationContext) {
			TestPropertySourceUtils.addInlinedPropertiesToEnvironment(applicationContext,
					"payu.api.url=http://localhost:" + wiremock.port());
		}

	}

}