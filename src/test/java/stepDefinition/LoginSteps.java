package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class LoginSteps {

	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage macc;

	@Given("the user navigates to login page")
	public void the_user_navigates_to_login_page() {
		BaseClass.getLogger().info("the user navigates to login page");

		hp = new HomePage(BaseClass.getDriver());

		hp.clickMyAccount();
		hp.clickLogin();
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		BaseClass.getLogger().info("user enters email as {string} and password as {string}");
		lp = new LoginPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(pwd);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
		BaseClass.getLogger().info("the user clicks on the Login button");
		lp.clickLogin();
	}

	@Then("the user should be redirected to the MyAccount Page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
		BaseClass.getLogger().info("the user should be redirected to the MyAccount Page");
		macc = new MyAccountPage(BaseClass.getDriver());
		boolean targetpage = macc.isMyAccountPageExists();

		Assert.assertEquals(targetpage, true);
	}

}
