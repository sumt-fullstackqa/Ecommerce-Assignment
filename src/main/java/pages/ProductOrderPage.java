package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testbase.Testbase;

public class ProductOrderPage extends Testbase {

	
	  WebDriver ldriver;
	
	@SuppressWarnings("static-access")
	public  ProductOrderPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);

	}
	
	@FindBy(how = How.CSS, using = "a[href*='my-account']")
	private WebElement Login;
	
	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//p[@class='submit']//span[1]")
	private WebElement signin;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]")
	private WebElement womenmainmenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	private WebElement itemimage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[2]")
	private WebElement morebutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"quantity_wanted\"]")
	private WebElement quantityfield;
	
	@FindBy(how = How.XPATH, using = "//select[@name='group_1']")
	private WebElement sizedropdown;

	@FindBy(how = How.XPATH, using = "//a[@name='Blue']")
	private WebElement color;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"add_to_cart\"]/button")
	private WebElement addtocartbutton;
	
	@FindBy(how = How.CSS, using = "a.btn:nth-child(2)")
	private WebElement proceedtocheckoutbutton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	private WebElement cartmenu;
	
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Check out')]")
	private WebElement cartmenucheckout;
	
	@FindBy(how = How.CSS, using = ".standard-checkout > span:nth-child(1)")
	private WebElement finalcheckout;
	
	@FindBy(how = How.CSS, using = "button.button:nth-child(4)")
	private WebElement addresscheckout;
	
	@FindBy(how = How.CSS, using = "button.button:nth-child(4) > span:nth-child(1)")
	private WebElement shippingcheckout;
			
	@FindBy(how = How.CSS, using = ".checkbox > label:nth-child(2)")
	private WebElement checkbox;
	
	@FindBy(how = How.XPATH, using = "//a[@class='cheque']")
	private WebElement pay;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]")
	private WebElement confirmorder;
	
	@FindBy(how = How.XPATH, using = "//p[@class='alert alert-success']")
	private WebElement successmessage;
	
	public void clicklogin() {
		
		waitForElementToBeClickable(Login, driver, 3000);
		writeLogs("login button is available to click");
	ClickOn(driver,Login , 3);
	writeLogs("clicked on login button successfully");
		
	}

	public void login(String Emailaddress, String Password) throws InterruptedException {

		waitForElementToBeVisible(email, driver, 4000);
		writeLogs("Email field is available");
	     sendKeys(driver, email, 5, Emailaddress);
	     writeLogs("entered email address in email field successfully");
	     waitForElementToBeVisible(password, driver, 4000);
			writeLogs("password field is available");
		     sendKeys(driver, password, 5, Password);
		     writeLogs("entered Password in Password field successfully");
		     waitForElementToBeClickable(signin, driver, 3000);
				writeLogs("sign in button is available to click");
			ClickOn(driver,signin , 3);
			writeLogs("clicked on sign in button and logged in to the website successfully");
	       	
	}
	
	public void navigatetoTshirts(){
		
		waitForElementToBeVisible(womenmainmenu, driver, 4000);
		writeLogs("women main menu  is available");
		mousehover(womenmainmenu);
		writeLogs("move your cursor to women main menu");
		List<WebElement> womensubmenulinks=womenmainmenu.findElements(By.tagName("a"));
		
		for (int i=0; i<=(womensubmenulinks.size()); i++){
			if (womensubmenulinks.get(i).getText().equals("T-shirts"))
			{
				womensubmenulinks.get(i).click();
				
			break;
		}
		}
		writeLogs("clicked on T-shirts sub menu successfully");
	}

	public void additemstocart(String quantityvalue, String sizevalue)  throws InterruptedException {
		
		waitForElementToBeVisible( itemimage, driver, 4000);
		writeLogs("tshirt item  is available");
		mousehover(itemimage);
		writeLogs("moveed your cursor to item image");
		waitForElementToBeClickable(morebutton, driver, 3000);
		writeLogs("more button is available to click");
	ClickOn(driver,morebutton , 3);
	writeLogs("clicked on more button successfully");
	quantityfield.clear();
	writeLogs("Quantity field is cleared");
	 sendKeys(driver, quantityfield, 5, quantityvalue);
     writeLogs("entered quantity value in quantity field successfully");
	dropDownList(sizedropdown, sizevalue);
	writeLogs("size is selected successfully");
	ClickOn(driver,color , 3);
	writeLogs("clicked on color box successfully");
	ClickOn(driver,addtocartbutton , 3);
	writeLogs("clicked on add to cart button successfully and item has been added to cart");
	
	}
	
	public void checkoutAndOrder() {
		
		waitForElementToBeClickable(proceedtocheckoutbutton, driver, 3000);
		writeLogs("checkout button is available to click");
	JSClickOn(driver, proceedtocheckoutbutton, 3);
	writeLogs("clicked on checkout button successfully");
	refresh(driver);
	mousehover(cartmenu);
	writeLogs("moveed your cursor to cart menu");
	JSClickOn(driver, cartmenucheckout , 3);
	writeLogs("clicked on cart menu checkout button successfully");
	JSClickOn(driver, finalcheckout , 3);
	writeLogs("clicked on final checkout button successfully");
	waitForElementToBeClickable(addresscheckout, driver, 3000);
	writeLogs("address checkout button is available to click");
	JSClickOn(driver, addresscheckout , 3);
	writeLogs("clicked on address checkout button successfully");
	waitForElementToBeClickable(checkbox, driver, 3000);
	writeLogs("checkbox is available to click");
	JSClickOn(driver, checkbox , 3);
	writeLogs("clicked on checkbox  successfully");
	waitForElementToBeClickable(shippingcheckout, driver, 3000);
	writeLogs("shippingcheckout button is available to click");
	JSClickOn(driver, shippingcheckout , 3);
	writeLogs("clicked on shipping checkout button successfully");
	waitForElementToBeClickable(pay, driver, 3000);
	writeLogs("pay button is available to click");
	JSClickOn(driver, pay , 3);
	writeLogs("clicked on pay button successfully");
	waitForElementToBeClickable(confirmorder, driver, 3000);
	writeLogs("confirm button is available to click");
	JSClickOn(driver, confirmorder , 3);
	writeLogs("clicked on confirm order button successfully");
	String successmessagetext= successmessage.getText();
	Assert.assertEquals(successmessagetext, "Your order on My Store is complete.");
	writeLogs("product is ordered successfully");
	
	}
	
	}

