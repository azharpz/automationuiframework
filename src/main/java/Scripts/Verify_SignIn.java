package Scripts;

import org.testng.annotations.Test;

import Base.BaseTest;
import PageEvents.HomePageEvents;

public class Verify_SignIn extends BaseTest{
	@Test
	public void Verify_SignIn(){
	HomePageEvents homepageevents=new HomePageEvents();
	
	homepageevents.clickSignInButton();
}

}