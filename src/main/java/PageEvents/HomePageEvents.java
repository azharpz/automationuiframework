package PageEvents;

import PageObjects.HomePageElements;
import util.ElementFetch;

public class HomePageEvents {

	public void clickSignInButton() {
		ElementFetch elementfetch=new ElementFetch();
		elementfetch.getWebElement("XPath", HomePageElements.signInButton).click();
		
		
		
	}
}
