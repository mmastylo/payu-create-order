package mm.test.payu.support;

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
public class Product {

	@NonNull
	private String name;

	@NonNull
	private String unitPrice;

	@NonNull
	private String quantity;

	private String virtual;

	private String listingDate;

}