package domapi;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

//import jdk.internal.org.xml.sax.SAXException;

/*
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
*/
public class App {
	public static void main(String[] args)
			throws ParserConfigurationException, IOException, TransformerException, org.xml.sax.SAXException

	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document document = builder.parse("src/main/resources/szalloda.xml");

		Szalloda szalloda = Szalloda.create(document);

		Szoba szoba = new Szoba();
		szoba.setId("143");

		Vendeg vendeg = new Vendeg();
		vendeg.setId("342344HJ");
		vendeg.setName("Kiss Anna");

		

		szalloda.addSzalloda(szoba, vendeg);

		szalloda.persist("src/main/resources/output.xml");

	}
}