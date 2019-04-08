

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class A4UnitTest {

	ShoppingCart cart = new ShoppingCart();
	Product p1 = new Product("Product 1", 4);

	@Test
	//When created, the cart has 0 items
	public void testCreationOfCart() 
	{
		assertFalse(cart.getItemCount() != 0);
	}
	
	@Test
	//When empty, the cart has 0 items
	public void testEmptyCart() 
	{
		cart.empty();
		assertFalse(cart.getItemCount() != 0);
	}

	@Test
	void productIncrementTest()
	{
		ShoppingCart cart = new ShoppingCart();
		int startNum = cart.getItemCount();
		cart.addItem(new Product("Product1", 1.00));
		int numAfterAdding = cart.getItemCount();
		boolean hasIncremented = false;
		if(startNum < numAfterAdding)
		{
			hasIncremented = true;
		}
		assertFalse(hasIncremented != true);
	}
	
	@Test
	void balanceIncrementTest()
	{
		double firstProductPrice = 1.00;
		double secondProductPrice = 3.00;
		double totalPrice = firstProductPrice + secondProductPrice;
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("Product1", firstProductPrice));
		double startBalance = cart.getBalance();
		cart.addItem(new Product("Product2", secondProductPrice));
		double endBalance = cart.getBalance();
		boolean hasIncremented = false;
		if(endBalance == totalPrice)
		{
			hasIncremented = true;
		}
		assertFalse(hasIncremented != true);
	}

	@Test
	void productDecrementTest() throws ProductNotFoundException
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("Product1", 2.00));
		Product testProduct = new Product("Product2", 4.00);
		cart.addItem(testProduct);
		int startNum = cart.getItemCount();
		cart.removeItem(testProduct);
		int numAfterRemoving = cart.getItemCount();
		boolean hasDecremented = false;
		if(startNum > numAfterRemoving)
		{
			hasDecremented = true;
		}
		assertFalse(hasDecremented != true);
	}
	
	@Test
	void productNotFound()
	{
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("Product1", 2.00));
		cart.addItem(new Product("Product2", 4.00));
		boolean exThrown = false;
		try {
			cart.removeItem(new Product("Product8", 4.00));
		} catch (ProductNotFoundException e) {
			exThrown = true;	//fail("Nonexistant product removed from cart - ProductNotFoundException");
		}
		assertTrue(exThrown);
	}
}
