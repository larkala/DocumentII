package element;

import elementenum.ElementType;

public class Paragraph extends Element<String, String>{

	private String content;
	
	public Paragraph(String content) {
		this.content = content;
	}
	
	@Override 
	public void addContent(String content) {
		this.content = content;
	}
	
	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void print() {
		System.out.println("<p>" + content + "</p>");
	}
	
	@Override
	public ElementType type() {
		return ElementType.PARAGRAPH;
	}
}
