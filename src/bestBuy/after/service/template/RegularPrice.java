package bestBuy.after.service.template;

import bestBuy.after.model.Cart;

public class RegularPrice extends BestBuyOfferTemplate {

	public RegularPrice(Cart cart) {
		super(cart);
	}

	@Override
	public boolean isAppliable() {
		return true;
	}

	@Override
	protected void calibrateVariables() {
		// Nothing to adjust!
	}

}
