package iger;

import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.link.Link;

public class MyComponent extends WebComponent {

	public MyComponent(String wicketId) {
		super(wicketId);
	}

	public void bebebe() {
		MyComponent myComponent = new MyComponent("myComponent");
	}

	class NextPageLink extends Link {
		public NextPageLink(String id) {
			super(id);
		}

		@Override
		public void onClick() {
			setResponsePage(new NextPage());
		}
	}

}
