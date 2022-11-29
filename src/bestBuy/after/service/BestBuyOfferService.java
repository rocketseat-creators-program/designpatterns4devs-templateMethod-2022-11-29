package bestBuy.after.service;

import java.util.ArrayList;
import java.util.List;

import bestBuy.after.model.Cart;
import bestBuy.after.service.template.BestBuyOfferTemplate;
import bestBuy.after.service.template.BigCartDiscounts;
import bestBuy.after.service.template.BlackFriday;
import bestBuy.after.service.template.CategoryDiscounts;
import bestBuy.after.service.template.FreeDelivery;
import bestBuy.after.service.template.RegularPrice;
import bestBuy.after.service.template.SpecialClient;

public class BestBuyOfferService {
    
    private List<BestBuyOfferTemplate> templates;
	
	private void loadTemplates(Cart cart) {
		templates = new ArrayList<BestBuyOfferTemplate>();
		templates.add(new RegularPrice(cart));
		templates.add(new FreeDelivery(cart));
		templates.add(new BigCartDiscounts(cart));
		templates.add(new SpecialClient(cart));
		templates.add(new CategoryDiscounts(cart));
		templates.add(new BlackFriday(cart));
	}
	

	public void calculateBestOffer(Cart cart) {
		loadTemplates(cart);
		Double bestOffer = Double.MAX_VALUE;
		for(BestBuyOfferTemplate template: templates) {
			if(template.isAppliable()) {
				Double currentPrice = template.calculateOffer(cart);
				System.out.println(String.format("%s: %.2f", template.getClass().getSimpleName(), currentPrice));
				bestOffer = (bestOffer > currentPrice)? currentPrice: bestOffer;
			}
		}
		System.out.println(String.format("Final Price: %.2f", bestOffer));
	}
}
