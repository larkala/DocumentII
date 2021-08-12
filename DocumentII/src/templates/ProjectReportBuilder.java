package templates;

import element.Document;
import element.Element;
import element.List;
import elementfactory.ElementFactory;
import elementfactory.ElementType;

public class ProjectReportBuilder implements DocumentBuilder{

	Document projectreport = new Document();
	private Element reportTitle = ElementFactory.create(ElementType.TITLE, "Project Report");
	private Element introductionTitle = ElementFactory.create(ElementType.TITLE, "Introduction");
	private Element introduction = ElementFactory.create(ElementType.PARAGRAPH, "not set");
	private Element resultTitle = ElementFactory.create(ElementType.TITLE, "Result");
	private Element result = ElementFactory.create(ElementType.PARAGRAPH, "not set");
	private Element referenceTitle = ElementFactory.create(ElementType.TITLE, "References");
	private Element references = ElementFactory.create(ElementType.LIST, "no references");
	private boolean referenceHasBeenAdded = false;
	
	public ProjectReportBuilder withTitle(String reportTitle) {
		this.reportTitle = ElementFactory.create(ElementType.TITLE, reportTitle);
		return this;
	}


	public ProjectReportBuilder withIntroductionTitle(String introductionTitle) {
		this.introductionTitle = this.reportTitle = ElementFactory.create(ElementType.TITLE, introductionTitle);
		return this;
	}

	public ProjectReportBuilder withIntroduction(String introduction) {
		this.introduction = ElementFactory.create(ElementType.PARAGRAPH, introduction);
		return this;
	}

	public ProjectReportBuilder withResultTitle(String resultTitle) {
		this.resultTitle = ElementFactory.create(ElementType.TITLE, resultTitle);
		return this;
	}

	public ProjectReportBuilder withResult(String result) {
		this.result = ElementFactory.create(ElementType.PARAGRAPH, result);
		return this;
	}

	public ProjectReportBuilder withReferenceTitle(String referenceTitle) {
		this.referenceTitle = ElementFactory.create(ElementType.TITLE, referenceTitle);
		return this;
	}

	public ProjectReportBuilder addReference(String reference) {
		if(!referenceHasBeenAdded) {
			referenceHasBeenAdded = true;
			references = (List) ElementFactory.create(ElementType.LIST, reference);
		}
		else 
			this.references.addContent(ElementFactory.create(ElementType.PARAGRAPH, reference));
		return this;
	}

	@Override
	public void build() {
		projectreport.addContent(reportTitle);
		projectreport.addContent(introductionTitle);
		projectreport.addContent(introduction);
		projectreport.addContent(resultTitle);
		projectreport.addContent(result);
		projectreport.addContent(referenceTitle);
		projectreport.addContent(references);
	}

	@Override
	public Document getResult() {
		return projectreport;
	}

}
