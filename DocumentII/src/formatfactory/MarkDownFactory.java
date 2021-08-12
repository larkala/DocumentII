package formatfactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import element.Document;
import element.Element;
import element.List;

public class MarkDownFactory implements DocFormatFactory{

	private BufferedWriter mdFile;
	
	@Override
	public void convertAndRender(String name, Document d) {
		ArrayList<Element> doc = d.getContent();

		try {
			mdFile = new BufferedWriter(new FileWriter(new File(name + ".md")));

			for(Element e: doc) {

				switch (e.type()) {
				case TITLE: 
					mdFile.write("# " + e.getContent());
					mdFile.newLine();
					break;

				case PARAGRAPH:
					mdFile.write(e.getContent() + "");
					mdFile.newLine();
					break;

				case LIST:
					List list = (List) e;
					for(Element li: list.getContent()) {
						mdFile.write("+ " + li.getContent());
						mdFile.newLine();
					}
					break;

				default:
					throw new IllegalArgumentException("Unexpected ElementType");
				}

			}

			mdFile.close();
			System.out.println("File written successfully");

		} catch (IOException ex) {
			System.out.println("Something went wrong.");
			ex.printStackTrace();
		}
	}
	
}
