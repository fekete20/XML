package domapi;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Szalloda {
	private String nev;
	private String cim;
	private String telefonszam;
	private String adoszam;
	private Szoba szoba;
	private Vendeg vendeg;
	
	public static Szalloda create(Node node) {
		Szalloda szalloda = new Szalloda();
		
		Element element = (Element) node;
		szalloda.nev = element.getAttribute("nev");
		szalloda.cim = element.getAttribute("cim");
		szalloda.telefonszam = element.getAttribute("telefonszam");
		szalloda.adoszam = element.getAttribute("telefonszam");
	
		return szalloda;
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getCim() {
		return cim;
	}

	public void setCim(String cim) {
		this.cim = cim;
	}

	public String getTelefonszam() {
		return telefonszam;
	}

	public void setTelefonszam(String telefonszam) {
		this.telefonszam = telefonszam;
	}

	public String getAdoszam() {
		return adoszam;
	}

	public void setAdoszam(String adoszam) {
		this.adoszam = adoszam;
	}

	public Szoba getSzoba() {
		return szoba;
	}

	public void setSzoba(Szoba szoba) {
		this.szoba = szoba;
	}

	public Vendeg getVendeg() {
		return vendeg;
	}

	public void setVendeg(Vendeg vendeg) {
		this.vendeg = vendeg;
	}
	
	

}
