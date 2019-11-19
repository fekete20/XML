package domapi;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Szoba {
		private String id;
		private String size;
		private String price;
		private String vendegId;
		private String vendegNev;
		private Vendeg vendeg;
		
		public static Szoba create(Node node) {
			Szoba szoba = new Szoba();
			
			Element element = (Element) node;
			szoba.id = element.getAttribute("szoba_ajtoszam");
			szoba.size = element.getAttribute("meret");
			szoba.price = element.getAttribute("ar");
			szoba.vendegId = element.getAttribute("vendeg_szigszam");
			szoba.vendegNev = element.getAttribute("nev");
		
			return szoba;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getVendegId() {
			return vendegId;
		}

		public void setVendegId(String vendegId) {
			this.vendegId = vendegId;
		}

		public String getVendegNev() {
			return vendegNev;
		}

		public void setVendegNev(String vendegNev) {
			this.vendegNev = vendegNev;
		}

		public Vendeg getVendeg() {
			return vendeg;
		}

		public void setVendeg(Vendeg vendeg) {
			this.vendeg = vendeg;
		}

		
		
		
}
