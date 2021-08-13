package command;

import element.Document;
import element.Title;

/**
 * A command that adds a title to the document.
 */
public class WriteTitleCommand implements CommandInterface{
	private Title title;

	public WriteTitleCommand(String title) {
		this.title = new Title(title);
	}

	@Override
	public void doIt(Document d) {
		d.addContent(title);
	}

	@Override
	public void undoIt(Document d) {
		d.removeLast();
	}

}
