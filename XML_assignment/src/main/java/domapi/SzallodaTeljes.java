package domapi;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SzallodaTeljes {

	private static final String SZALLODA_TAG = "szalloda";
	private static final String SZOBA_TAG = "szoba";
	private static final String VENDEG_TAG = "vendeg";
	
	private Document root;
	private List<Szalloda> szallodak;
	private List<Szoba> szobak;
	private List<Vendeg> vendegek;
	public SzallodaTeljes(Document root, List<Szalloda> szallodak, List<Szoba> szobak, List<Vendeg> vendegek) {
	//	super();
		this.root = root;
		this.szallodak = szallodak;
		this.szobak = szobak;
		this.vendegek = vendegek;
	}
	
	public static SzallodaTeljes create(Document document) {
		Element root = document.getDocumentElement();
		if(!root.getNodeName().equals(SZALLODA_TAG)) {
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
		nodeList = root.getElementsByTagName(SZALLODA_TAG); 
		List<Szalloda> szallodak = new ArrayList<Szalloda>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			szallodak.add(Szalloda.create(node));
		}
		
		SzallodaTeljes szt = new SzallodaTeljes(document, szallodak, szobak, vendegek);
		
		
		
		return szt;
	}
	

}
