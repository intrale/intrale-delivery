package ar.com.intrale.messages;

import javax.validation.constraints.NotBlank;

import ar.com.intrale.RequestChild;
import edu.umd.cs.findbugs.annotations.NonNull;

public class OrderProductMessage extends RequestChild{

	@NonNull
    @NotBlank
	private String productId;

	@NonNull
    @NotBlank
	private Long count;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
