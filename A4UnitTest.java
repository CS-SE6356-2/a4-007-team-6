

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class main {

	ShoppingCart cart = new ShoppingCart();
	Product p1 = new Product("Product 1", 4);

	@Test
	//When created, the cart has 0 items
	public void testCreationOfCart() {
		assertFalse(cart.getItemCount() != 0);
	}
	
	@Test
	//When empty, the cart has 0 items
	public void testEmptyCart() {
		cart.empty();
		assertFalse(cart.getItemCount() != 0);
	}

}
