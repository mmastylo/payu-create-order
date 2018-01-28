package mm.test.payu.support;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@ToString
public class OrderCreateResponse {

	@NonNull
	private Status status;

	private String redirectUri;

	private String orderId;

	private String extOrderId;

}