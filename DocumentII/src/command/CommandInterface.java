package command;

import element.Document;

public interface CommandInterface{
	
	public void doIt(Document d);
	public void undoIt(Document d);
	
}
