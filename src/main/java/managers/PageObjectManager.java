package managers;

import PageObjects.HomeScreen;
import PageObjects.ProductsScreen;
import PageObjects.RegisterScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PageObjectManager {
	private AndroidDriver driver;
	private HomeScreen home;
	private RegisterScreen register;
	private ProductsScreen products;

	public PageObjectManager(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public HomeScreen getHomeScreen() {
		return (home == null) ? home = new HomeScreen(driver) : home;
	}

	public RegisterScreen getRegisterScreen() {
		return (register == null) ? register = new RegisterScreen(driver) : register;
	}

	public ProductsScreen getProductsScreen() {
		return (products == null) ? products = new ProductsScreen(driver) : products;
	}
}