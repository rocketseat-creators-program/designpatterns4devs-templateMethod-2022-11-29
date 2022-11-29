package bestBuy.after.service.template;

import bestBuy.after.model.Cart;

public class FreeDelivery extends BestBuyOfferTemplate {

	public FreeDelivery(Cart cart) {
		super(cart);
	}

	@Override
	public boolean isAppliable() {
		return regularItemsPrice > 500;
	}

	@Override
	protected void calibrateVariables() {
		deliveryFactor = 0d;
	}

}
