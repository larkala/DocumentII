package element;

import java.util.ArrayList;

import elementenum.ElementType;

@SuppressWarnings("rawtypes")
public class Document extends Element<ArrayList<Element>, Element>{

	private ArrayList<Element> document = new ArrayList<>();

	@Override
	public ArrayList<Element> getContent() {
		return document;
	}

	@Override
	public void print(){
		System.out.println("#### DOCUMENT START ####");
		for(Element e: document) {
			e.print();
			System.out.println();
		}

		System.out.println("#### DOCUMENT END ####");
	}
	
	@Override
	public Element getContent(int i) {
		return document.get(i);
	}

	@Override
	public void addContent(Element e) {
		document.add(e);
	}
	
	@Override
	public ElementType type() {
		return ElementType.DOCUMENT;
	}
	
	/**
	 * Removes the last element that was added to the document
	 */
	public void removeLast() {
		document.remove(document.size()-1);
	}
	
	
}
