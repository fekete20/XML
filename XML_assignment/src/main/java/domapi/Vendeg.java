package domapi;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Vendeg {
	private String nev;
	private String cim;
	private String telefonszam;
	private String szigsz;
	private Szalloda szalloda;
	
	public static Vendeg create(Node node) {
		Vendeg vendeg = new Vendeg();
		
		Element element = (Element) node;
		vendeg.nev = element.getAttribute("nev");
		vendeg.cim = element.getAttribute("cim");
		vendeg.telefonszam = element.getAttribute("telefonszam");
		vendeg.szigsz = element.getAttribute("szigsz");
	
		return vendeg;
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

	public String getSzigsz() {
		return szigsz;
	}

	public void setSzigsz(String szigsz) {
		this.szigsz = szigsz;
	}

	public Szalloda getSzalloda() {
		return szalloda;
	}

	public void setSzalloda(Szalloda szalloda) {
		this.szalloda = szalloda;
	}
	
	

}
