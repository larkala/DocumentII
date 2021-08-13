package templates;

import java.util.ArrayList;

import command.CommandInterface;
import command.Invoker;
import command.WriteListCommand;
import command.WriteParagraphCommand;
import command.WriteTitleCommand;
import element.Document;
import element.Element;
import element.List;
import elementfactory.ElementFactory;
import elementfactory.ElementType;

public class ProjectReportBuilder implements DocumentBuilder{

	Document projectreport = new Document();
	
	Invoker invoker = new Invoker(projectreport);
	
	ArrayList<String> defaultref = new ArrayList<String>();
	  
	
	private CommandInterface reportTitle = new WriteTitleCommand("Project Report");
	private CommandInterface introductionTitle = new WriteTitleCommand("Introduction");
	private CommandInterface introduction = new WriteParagraphCommand("not set");
	private CommandInterface resultTitle = new WriteTitleCommand("Result");
	private CommandInterface result = new WriteParagraphCommand("not set");
	private CommandInterface referenceTitle = new WriteTitleCommand("References");
	private CommandInterface references = new WriteListCommand(new ArrayList<String>());
	
	boolean referenceHasBeenAdded = false;
	ArrayList<String> refList = new ArrayList<>();
	
	public ProjectReportBuilder withTitle(String reportTitle) {
		this.reportTitle = new WriteTitleCommand(reportTitle);
		return this;
	}


	public ProjectReportBuilder withIntroductionTitle(String introductionTitle) {
		this.introductionTitle = new WriteTitleCommand(introductionTitle);
		return this;
	}

	public ProjectReportBuilder withIntroduction(String introduction) {
		this.introduction = new WriteParagraphCommand(introduction);
		return this;
	}

	public ProjectReportBuilder withResultTitle(String resultTitle) {
		this.resultTitle = new WriteTitleCommand(resultTitle);
		return this;
	}

	public ProjectReportBuilder withResult(String result) {
		this.result = new WriteParagraphCommand(result);
		return this;
	}

	public ProjectReportBuilder withReferenceTitle(String referenceTitle) {
		this.referenceTitle = new WriteTitleCommand(referenceTitle);
		return this;
	}

	public ProjectReportBuilder addReference(String reference) {
		refList.add(reference);
		return this;
	}

	@Override
	public void build() {
		references = new WriteListCommand(refList);
		
		invoker.addCommand(reportTitle);
		invoker.addCommand(introductionTitle);
		invoker.addCommand(introduction);
		invoker.addCommand(resultTitle);
		invoker.addCommand(result);
		invoker.addCommand(referenceTitle);
		invoker.addCommand(references);
		invoker.repeatCommand();
		invoker.undoCommand();
		invoker.repeatCommand();
		invoker.addCommand(reportTitle);
		invoker.undoCommand();
	}

	@Override
	public Document getResult() {
		return projectreport;
	}

}
