package main;

import element.Document;
import formatfactory.HTMLFactory;
import formatfactory.MarkDownFactory;
import templates.ProjectReportBuilder;
import templates.ProjectReportDirector;

public class App {
	
	public static void main(String[] args) {
		ProjectReportBuilder builder = new ProjectReportBuilder();
		ProjectReportDirector director = new ProjectReportDirector(builder);
		
		director.direct();
		Document myReport = builder.getResult();
		
		new HTMLFactory().convertAndRender("project report html", myReport);
	}
}
