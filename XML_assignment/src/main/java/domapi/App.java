package domapi;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

public class App {
	public static void main(String[] args)
			throws ParserConfigurationException, IOException, TransformerException, org.xml.sax.SAXException

	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse("src/main/resources/szalloda.xml");

		Szalloda szalloda = Szalloda.create(document);

		// új elem beszúrása
		Szoba szoba = new Szoba();
		szoba.setId("143");

		Vendeg vendeg = new Vendeg();
		vendeg.setId("342344HJ");
		vendeg.setName("Tóth Gábor");

		szalloda.addSzalloda(szoba, vendeg);
		// módosított dom fa mentése
		szalloda.persist("src/main/resources/output.xml");

		// keresés ID alapján vendégre
		Vendeg v = new Vendeg();
		v = szalloda.getVendegById("456744IO");
		System.out.println("A keresett vendég: " + v.getId() + " " + v.getName());

		// keresés ID alapján szobára
		Szoba sz = new Szoba();
		sz = szalloda.getSzobaById("123");
		System.out.println("A keresett szoba: " + sz.getId() + ", mérete: " + sz.getSize() + ", ára: " + sz.getPrice());

	}
}