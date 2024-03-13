package com.open.hotel.runner;

import com.techx.core.utils.PropMgr;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		plugin={
				"pretty",
				"html:target/cucumberReport",
				"pretty:target/cucumber-json-report.json",
				"json:target/json/cucumber.json",
		},
		tags={"@SmokeTest"},
		features = "src/test/java/com/open/hotel/features/Login.feature",
		glue={"efx.ecuke.core.hooks", "com.open.hotel.hooks", "com.open.hotel.stepdefinitions"},
		strict = true,
		dryRun = false
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider (parallel = true)
	public Object[][] scenarios() {

		return super.scenarios();
	}

	@BeforeSuite()
	public void setup() throws NoSuchFieldException, IllegalAccessException {
		String propfilepath = System.getProperty("user.dir") + "\\src\\test\\resources\\";
		PropMgr.init(propfilepath);
		System.out.println("Before Suite done");
	}

	@AfterSuite()
	public void afterSuite(){
		System.out.println("After Suite done");
	}

}
