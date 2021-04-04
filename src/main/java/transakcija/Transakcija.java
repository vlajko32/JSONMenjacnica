package transakcija;

import java.util.Date;

public class Transakcija {

	public String izvornaValuta;

	public String krajnjaValuta;

	public double pocetniIznos;

	public double konvertovaniIznos;

	public Date datumTransakcije;

	public String getIzvornaValuta() {
		return izvornaValuta;
	}

	public void setIzvornaValuta(String izvornaValuta) {
		this.izvornaValuta = izvornaValuta;
	}

	public String getKrajnjaValuta() {
		return krajnjaValuta;
	}

	public void setKrajnjaValuta(String krajnjaValuta) {
		this.krajnjaValuta = krajnjaValuta;
	}

	public double getPocetniIznos() {
		return pocetniIznos;
	}

	public void setPocetniIznos(double pocetniIznos) {
		this.pocetniIznos = pocetniIznos;
	}

	public double getKonvertovaniIznos() {
		return konvertovaniIznos;
	}

	public void setKonvertovaniIznos(double konvertovaniIznos) {
		this.konvertovaniIznos = konvertovaniIznos;
	}

	public Date getDatumTransakcije() {
		return datumTransakcije;
	}

	public void setDatumTransakcije(Date datumTransakcije) {
		this.datumTransakcije = datumTransakcije;
	}

	@Override
	public String toString() {
		return "Transakcija [izvornaValuta=" + izvornaValuta + ", krajnjaValuta=" + krajnjaValuta + ", pocetniIznos="
				+ pocetniIznos + ", konvertovaniIznos=" + konvertovaniIznos + ", datumTransakcije=" + datumTransakcije
				+ "]";
	}

	public Transakcija(String izvornaValuta, double pocetniIznos, Date datumTransakcije) {
		super();
		this.izvornaValuta = izvornaValuta;
		this.pocetniIznos = pocetniIznos;
		this.datumTransakcije = datumTransakcije;
	}

	public Transakcija() {
		super();
	}
	
	public static void konvertuj(Transakcija t, double valuta, String krajnjaValuta) {
		t.setKonvertovaniIznos(t.getPocetniIznos() * valuta);
		t.setKrajnjaValuta(krajnjaValuta);
	}
	
}



