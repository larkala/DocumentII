package command;

import java.util.ArrayList;

import element.Document;


public class Invoker {

	private ArrayList<CommandInterface> commandList = new ArrayList<CommandInterface>();
	private int index = 0;
	private final Document doc;

	public Invoker(Document d) {
		this.doc = d;	
	}

	public void addCommand(CommandInterface command) {
		if (index < commandList.size())
			commandList.subList(index, commandList.size() - 1).clear();
		commandList.add(command);
		command.doIt(doc);
		index++;
	}

	public void undoCommand() {
		if (commandList.size() < 1)
			return;
		else {
			index--;
			commandList.get(index-1).undoIt(doc);
		}
	}

	public void repeatCommand() {
		if (commandList.size() == 0)
			return;

		//If the pointer is at the end of the list, repeat the command again and increase the index
		if (index == commandList.size()) {
			CommandInterface copy = commandList.get(index-1);
			addCommand(copy);
			index++;
		}
	}
}
