package templates;

import element.Document;
import element.Title;

public interface DocumentBuilder {
	public void build();
	public Document getResult();
}
