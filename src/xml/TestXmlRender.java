package xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;

public class TestXmlRender {
	public static void main(String[] args) {
		Document doc = new DOMDocument();
		Element response = new DOMElement("RESPONSE");
		response.add(newElement("RESULT", "SUCCESS"));
		doc.setRootElement(response);
		System.out.println(doc.asXML());
	}

	public static Element newElement(String name, String value) {
		Element elem = new DOMElement(name);
		// elem.addCDATA(value);
		elem.setText(value);
		return elem;
	}

}
