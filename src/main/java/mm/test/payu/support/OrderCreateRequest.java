package mm.test.payu.support;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@ToString
public class OrderCreateRequest {

	private String extOrderId;

	private String notifyUrl;

	@NonNull
	private String customerIp;

	@NonNull
	private String merchantPosId;

	@NonNull
	private String description;

	@NonNull
	private String currencyCode;

	@NonNull
	private String totalAmount;

	private Buyer buyer;

	@NonNull
	private List<Product> products;

}