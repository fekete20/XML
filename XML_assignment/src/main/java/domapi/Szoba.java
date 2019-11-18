package domapi;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Szoba {
		private String meret;
		private String ar;
		private String ajtoszam;
		private Szalloda szalloda;
		
		public static Szoba create(Node node) {
			Szoba szoba = new Szoba();
			
			Element element = (Element) node;
			szoba.meret = element.getAttribute("meret");
			szoba.ar = element.getAttribute("ar");
			szoba.ajtoszam = element.getAttribute("ajtoszam");
			
		
			return szoba;
		}

		public String getMeret() {
			return meret;
		}

		public void setMeret(String meret) {
			this.meret = meret;
		}

		public String getAr() {
			return ar;
		}

		public void setAr(String ar) {
			this.ar = ar;
		}

		public String getAjtoszam() {
			return ajtoszam;
		}

		public void setAjtoszam(String ajtoszam) {
			this.ajtoszam = ajtoszam;
		}

		public Szalloda getSzalloda() {
			return szalloda;
		}

		public void setSzalloda(Szalloda szalloda) {
			this.szalloda = szalloda;
		}
		
		
}
