package EcommerceAssignment.EcommerceAssignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import pages.ProductOrderPage;
import testbase.Testbase;


public class ProductOrderTest extends Testbase {
	
	ProductOrderPage p1;

	@Test(priority = 1)
	public void basepagenavigation() throws IOException {

		// 1. open link 
		driver.get(prop.getProperty("url"));

		// creating object of that class and invoking method of it
		p1 = new ProductOrderPage(driver);
		
        p1.clicklogin();
		
	}

	@Test(priority = 2)
	
	public void logintest() throws InterruptedException {
		
		//2. Login to the website
		
	p1.login(prop.getProperty("email"), prop.getProperty("password"));
	
	}
	
	@Test(priority = 3)
	public void tshirtsubmenuclickTest(){
		
		//3. move your cursor over women's link and 4. click on sub-menu "T-shirts".
		
		p1.navigatetoTshirts();
	}
	
	@Test(priority = 4)
	
	public void addDesiredItems() throws InterruptedException{
		
		//5.Mouse hover on the second product displayed(comment- only 1 item available so clicking on that item only) 
		//6. 'More' button will be displayed,click on the 'More' button.
		//7. Increase quantity to 2
		//8. select size L
		//9. select color
		//10. click the "Add to cart" button
		
	p1.additemstocart(prop.getProperty("quantity"), prop.getProperty("size"));
	
	}
	@Test(priority = 5)
	
 public void orderproduct() {
	 
	 //. 11. click the "proceed to checkout button"
	 //12. complete the buy order process for payment
	//13. make sure that the product is ordered 
	 
	 p1.checkoutAndOrder();
 }

	}