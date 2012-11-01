package lv.javaguru.ui.page;

import java.util.Map;

import lv.javaguru.app.Context;
import lv.javaguru.app.service.CourseService;
import lv.javaguru.model.Course;
import lv.javaguru.ui.WicketApplication;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public HomePage(final PageParameters parameters) {
		Map<String, Course> courseMap = ((WicketApplication) getApplication())
				.getCourseService().getMap();
		for (final String courseId : courseMap.keySet()) {
			add(new BookmarkablePageLink<CoursePage>("course" + courseId,
					CoursePage.class, new PageParameters() {
						{
							add("course", courseId);
						}
					}));
		}
	}
}
