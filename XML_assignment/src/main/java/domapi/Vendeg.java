package domapi;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Vendeg {
	private String id;
	private String name;

	public static Vendeg create(Node node) {
		Vendeg vendeg = new Vendeg();

		Element element = (Element) node;
		vendeg.id = element.getAttribute("vendeg_szigszam");
		vendeg.name = element.getAttribute("nev");
		return vendeg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
