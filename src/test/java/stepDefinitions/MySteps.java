package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.*;
import testCases.BaseTest;
import testCases.BeCognizant;
import testCases.OneCognizant;
import testCases.TruTime;

public class MySteps {
	
	BaseTest baseTest = new BaseTest();
	
	@Given("Launching user BeCognizant page")
	public void launching_user_be_cognizant_page() {
		
		baseTest.setup("chrome");
	}

	@Then("Verifying details present on BeCognizant page and clicking OneCognizant")
	public void verifying_details_present_on_be_cognizant_page_and_clicking_one_cognizant() throws IOException {
		BeCognizant beCogni = new BeCognizant();
		try {
			beCogni.getInfo();
			beCogni.verifyOneCogni();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	@Then("Searching TruTime on OneCognizant and verifying TruTime page")
	public void searching_tru_time_on_one_cognizant_and_verifying_tru_time_page() throws InterruptedException {
	   OneCognizant oneCogni = new OneCognizant();
	   
		oneCogni.searchTruTime();
		oneCogni.validateTruTimePage();
	
	}

	@Then("Verifying details present on TruTime page")
	public void verifying_details_present_on_tru_time_page() throws IOException {
		TruTime truTime = new TruTime();
		truTime.validateCurrentMonthAndYear();
		truTime.validateBackDatedTopUp();
		truTime.printLegends();
		truTime.validateCurrentHighlightedDate();
		truTime.validateTruTimeDates();
	}

	@Then("Closing the browser")
	public void closing_the_browser() {
		baseTest.tearDown();
	}
}
