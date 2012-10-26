package lv.javaguru.ui.page;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.model.Course;
import lv.javaguru.ui.WicketApplication;
import lv.javaguru.ui.page.HomePage;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
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
