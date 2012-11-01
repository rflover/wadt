package lv.javaguru.ui.page;

import lv.javaguru.app.Context;
import lv.javaguru.db.DriverManagerDatabase;
import lv.javaguru.ui.WicketApplication;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void before()
	{
		Context.reset();
		
		tester = new WicketTester(new WicketApplication());

		DriverManagerDatabase database = new DriverManagerDatabase(); 
		database.setConnectString("jdbc:hsqldb:file:wadtdb");
		database.setUser("SA"); 
		database.setPassword("");
		Context.put(Context.DB_DATABASE, database); 
		
		Context.init();
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		//start and render the test page
		tester.startPage(HomePage.class);

		//assert rendered page class
		tester.assertRenderedPage(HomePage.class);
	}
}
