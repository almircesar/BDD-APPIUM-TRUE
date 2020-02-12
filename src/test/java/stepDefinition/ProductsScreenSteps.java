package stepDefinition;

import PageObjects.ProductsScreen;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;
import managers.TestContext;

public class ProductsScreenSteps {

	ProductsScreen products;
	AndroidDriver driver;
	TestContext testContext;

	public ProductsScreenSteps(TestContext context) {
		testContext = context;
		products = testContext.getPageObjectManager().getProductsScreen();
	}

	@Quando("^escolho o produto desejado$")
	public void escolho_o_produto_desejado() throws InterruptedException {
		products.clickProduct();

	}

	@Entao("^deve estar na tela do produto desejado$")
	public void deve_estar_na_tela_do_produto_desejado() throws InterruptedException {
		products.checkProduct();
	}

	@Entao("^deve estar na tela de produto nao encontrado$")
	public void deve_estar_na_tela_de_produto_nao_encontrado() {
		products.checkProductNotFound();
	}
	
	@Quando("^aplico os filtros invalidos$")
	public void aplico_os_filtros_invalidos() {
		products.clickFilter();
		products.clickColor();
		products.clickWireless();
		products.clickManufacturer();
		products.clickApply();
	}

}
