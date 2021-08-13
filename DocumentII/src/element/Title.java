package element;

import elementenum.ElementType;

public class Title extends Element<String, String>{ 

	private String content;
	public Title(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public void print() {
		System.out.println("<t>" + content + "</t>");
	}
	
	@Override
	public void addContent(String content) {
		this.content = content;
	}
	
	@Override
	public ElementType type() {
		return ElementType.TITLE;
	}

}
