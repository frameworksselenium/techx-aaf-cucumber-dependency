package com.open.hotel.stepdefinitions;

import com.techx.core.context.TestContext;
import com.open.hotel.pages.Login;
import com.techx.core.utils.PropMgr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SetpDefinition {

	private TestContext context;
	public SetpDefinition(TestContext context){
		this.context = context;
	}
	@Given("Open Browser")
	public void Open_Browser() {
		this.context.initContext();
		String env = PropMgr.get("env");
		String url = PropMgr.get(env + "_env_url");
		this.context.driver().openUrl(url);
	}

	@When("User enters the {string} and {string} and Click LogIn button")
	public void user_enters_the_and(String username, String password) throws Exception {
		Login login = context.getPageObject(Login.class);
		login.login(username, password).loginApp();
	}

}