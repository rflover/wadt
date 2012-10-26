package iger;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class WebPanel extends Panel {

	public WebPanel(String id) {
		super(id);
		 add(new Label("message", "Hello World!"));
	}

	/**
	 * 
	 */

}
