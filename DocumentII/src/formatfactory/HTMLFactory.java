package formatfactory;
import element.Document;
import element.Element;
import element.List;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLFactory implements DocFormatFactory{

	private BufferedWriter htmlFile;

	@Override
	public void convertAndRender(String name, Document d) {
		ArrayList<Element> doc = d.getContent();

		try {
			htmlFile = new BufferedWriter(new FileWriter(new File(name + ".html")));

			for(Element e: doc) {

				switch (e.type()) {
				case TITLE: 
					htmlFile.write("<h2>" + e.getContent() + "</h2>");
					htmlFile.newLine();
					break;

				case PARAGRAPH:
					htmlFile.write("<p>" + e.getContent() + "</p>");
					htmlFile.newLine();
					break;

				case LIST:
					List list = (List) e;
					htmlFile.write("<ul>");
					htmlFile.newLine();

					for(Element li: list.getContent()) {
						htmlFile.write("<li> " + li.getContent() + "</li>");
						htmlFile.newLine();
					}

					htmlFile.write("</ul>");
					htmlFile.newLine();
					break;

				default:
					throw new IllegalArgumentException("Unexpected ElementType");
				}

			}

			htmlFile.close();
			System.out.println("File written successfully");

		} catch (IOException ex) {
			System.out.println("Something went wrong.");
			ex.printStackTrace();
		}
	}

}
