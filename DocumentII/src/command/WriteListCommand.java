package command;

import java.util.ArrayList;

import element.Document;
import element.List;
import element.Paragraph;

/**
 * A command that adds a list to the document.
 */
public class WriteListCommand implements CommandInterface{
	List list = new List();

	/**
	 * Constructs the list command.
	 * 
	 * @param listcontent Strings to create the list from.
	 */
	public WriteListCommand(ArrayList<String> listcontent) {
		for(String content: listcontent)
			list.addContent(new Paragraph(content));
	}

	@Override
	public void doIt(Document d) {
		d.addContent(list);
	}

	@Override
	public void undoIt(Document d) {
		d.removeLast();
	}

}
