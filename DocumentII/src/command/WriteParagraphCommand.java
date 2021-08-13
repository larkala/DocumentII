package command;

import element.Document;
import element.Paragraph;

/**
 * A command that adds a paragraph to the document.
 */
public class WriteParagraphCommand implements CommandInterface{

	private Paragraph paragraph;

	public WriteParagraphCommand(String paragraph) {
		this.paragraph = new Paragraph(paragraph);
	}

	@Override
	public void doIt(Document d) {
		d.addContent(paragraph);
	}

	@Override
	public void undoIt(Document d) {
		d.removeLast();
	}

}
