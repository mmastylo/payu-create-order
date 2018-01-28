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
public class Buyer {

	private String customerId;

	private String extCustomerId;

	@NonNull
	private String email;

	private String phone;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

}