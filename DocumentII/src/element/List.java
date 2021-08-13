package element;

import java.util.ArrayList;

import elementenum.ElementType;

@SuppressWarnings("rawtypes")
public class List extends Element<ArrayList<Element>, Element>{

	private ArrayList<Element> list = new ArrayList<>();
	
	@Override
	public ArrayList<Element> getContent() {
		return list;
	}

	@Override
	public void print(){
		System.out.println("<list>");
		for(Element e: list)
			System.out.println("• "+ e.getContent());
		System.out.println("</list>");
	}

	@Override
	public void addContent(Element e) {
		list.add(e);
	}

	@Override
	public Element getContent(int i) {
		return list.get(i);
	}
	
	@Override
	public ElementType type() {
		return ElementType.LIST;
	}

}
