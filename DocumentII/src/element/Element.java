package element;

import elementenum.ElementType;
import exceptions.ElementException;

public abstract class Element<T1,T2> {
	
	public T2 getContent(int i) {
		throw new ElementException("This method only works for composites composed of other elements, e.g. List and Document");
	};
	
	public abstract T1 getContent();
	public abstract void addContent(T2 content);
	public abstract void print();
	public abstract ElementType type();
}
