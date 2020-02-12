package stepDefinition;

import org.junit.Assert;

import PageObjects.RegisterScreen;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;
import managers.TestContext;

public class RegisterScreenSteps {

	RegisterScreen register;
	AndroidDriver driver;
	TestContext testContext;

	public RegisterScreenSteps(TestContext context) {
		testContext = context;
		register = testContext.getPageObjectManager().getRegisterScreen();
	}

	@Quando("^eu preencho todos os campos obrigatorios$")
	public void eu_preencho_todos_os_campos_obrigatorios() {
		register.enterUsername(username);
		register.enterEmail(email);
		register.enterPassword(password);
		register.enterConfirmPassword(confirmPassword);
		register.enterFirstName(firstName);
		register.enterLastName(lastName);
		register.enterPhone(phone);
		register.scrollDown();
		register.slcCountry(country);
		register.enterState(state);
		register.enterAddress(address);
		register.enterCity(city);
		register.enterZIP(zip);
		register.btnRegister().click();
	}

	@Quando("^eu preencho todos os campos obrigatorios, exceto o email$")
	public void eu_preencho_todos_os_campos_obrigatorios_exceto_email() {
		register.enterUsername(username);
		register.enterPassword(password);
		register.enterConfirmPassword(confirmPassword);
		register.enterFirstName(firstName);
		register.enterLastName(lastName);
		register.enterPhone(phone);
		register.scrollDown();
		register.slcCountry(country);
		register.enterState(state);
		register.enterAddress(address);
		register.enterCity(city);
		register.enterZIP(zip);
	}

	@Entao("^o botao de registrar deve estar indisponivel para cliques$")
	public void botao_de_registrar_indisponivel() {
		Assert.assertFalse(register.btnRegister().isEnabled());
	}

	String username = "Alanar2";
	String email = "almir_cesar@hotmail.com.br";
	String password = "Senha14Aa";
	String confirmPassword = "Senha14Aa";
	String firstName = "Almir Cesar";
	String lastName = "Santos";
	String country = "Brazil";
	String phone = "11983772839";
	String state = "RJ";
	String address = "Rua das flores";
	String city = "Osasco";
	String zip = "06447563";
}
