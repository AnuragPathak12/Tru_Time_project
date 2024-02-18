package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BeCogniPage;

public class BeCognizant extends BaseTest {
	
	public BeCogniPage beCogniPage; 
	
	@Test(priority = 1)
	public void getInfo() throws InterruptedException, IOException {
		
		beCogniPage = new BeCogniPage(driver);
		beCogniPage.clickAccDetails();

		Assert.assertEquals(beCogniPage.getAccManagerName(), "Pathak, Anurag (Cognizant)");
		Assert.assertEquals(beCogniPage.getAccManagerEmail(), "2304075@cognizant.com");

	}
	
	@Test(priority = 2, dependsOnMethods = {"getInfo"})
	public void verifyOneCogni() throws InterruptedException {
		
		Assert.assertEquals(beCogniPage.verifyOneCogni(), "OneCognizant", "One Cognizant NOT found");
		beCogniPage.clickOnOneCogni();
		
	}
	
}
