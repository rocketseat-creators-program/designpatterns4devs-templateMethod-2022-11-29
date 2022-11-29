package bestBuy.after.service.template;

import bestBuy.after.model.Cart;

public class BlackFriday extends BestBuyOfferTemplate {

	public BlackFriday(Cart cart) {
		super(cart);
	}

	@Override
	public boolean isAppliable() {
		return true;  //FIXME we should use calendar to be dinamic
	}

	@Override
	protected void calibrateVariables() {
		priceFactor = 0.75d;
	}
}
