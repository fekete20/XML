package domapi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Szalloda {
	private static final String SZALLODA_TAG = "szalloda";
	private static final String SZOBA_TAG = "szoba";
	private static final String VENDEG_TAG = "vendeg";

	private Document root;
	private List<Szoba> szobak;
	private List<Vendeg> vendegek;

	public Szalloda(Document root, List<Szoba> szobak, List<Vendeg> vendegek) {
		this.root = root;
		this.szobak = szobak;
		this.vendegek = vendegek;
	}

	public static Szalloda create(Document document) {
		Element root = document.getDocumentElement();
		if (!root.getNodeName().equals(SZALLODA_TAG)) {
			throw new IllegalArgumentException("Nem szálloda a gyökérelem!");
		}
		NodeList nodeList = root.getElementsByTagName(SZOBA_TAG);
		List<Szoba> szobak = new ArrayList<Szoba>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			szobak.add(Szoba.create(node));
		}
		nodeList = root.getElementsByTagName(VENDEG_TAG);
		List<Vendeg> vendegek = new ArrayList<Vendeg>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			vendegek.add(Vendeg.create(node));
		}
		Szalloda szalloda = new Szalloda(document, szobak, vendegek);

		szobak.forEach(szoba -> szoba.setVendeg(szalloda.getVendegById(szoba.getVendegId())));
		return szalloda;
	}

	public Szoba getSzobaById(String id) {
		return szobak.stream().filter(szoba -> szoba.getId().equals(id)).findFirst().orElseGet(Szoba::new);
	}

	public Vendeg getVendegById(String id) {
		return vendegek.stream().filter(vendeg -> vendeg.getId().equals(id)).findFirst().orElseGet(Vendeg::new);
	}

	public void addSzalloda(Szoba szoba, Vendeg vendeg) {
		Element element = root.createElement(SZOBA_TAG);
		element.setAttribute("szoba_ajtoszam", szoba.getId());

		Element eVendeg = root.createElement(VENDEG_TAG);
		eVendeg.setAttribute("vendeg_szigszam", vendeg.getId());
		eVendeg.setAttribute("nev", vendeg.getName());

		root.getDocumentElement().appendChild(element);
		element.appendChild(eVendeg);

		szobak.add(szoba);
		vendegek.add(vendeg);

	}
	public void persist(String pathname) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		DOMSource source = new DOMSource(root);
		StreamResult result = new StreamResult(new File(pathname));
		transformer.transform(source, result);
	}

}
