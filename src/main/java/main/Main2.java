package main;

import java.net.HttpURLConnection;
import java.util.Date;

import com.google.gson.JsonObject;

import servis.APIServis;
import servis.JSONServis;
import transakcija.Transakcija;

public class Main2 {

	public static void main(String[] args) {

		Transakcija t = new Transakcija();
		t.setIzvornaValuta("USD");
		t.setPocetniIznos(97);
		Date datum = new Date(2020, 6, 24);
		


		Transakcija[] transakcije = {new Transakcija("USD", 100, datum), new Transakcija("USD", 100, datum), new Transakcija("USD", 100, datum) };

		HttpURLConnection con = APIServis.get(t, null);

		JsonObject res = APIServis.responseToJson(con);

		double eur = res.get("quotes").getAsJsonObject().get("USDEUR").getAsDouble();
		double chf = res.get("quotes").getAsJsonObject().get("USDCHF").getAsDouble();
		double cad = res.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble();

		Transakcija.konvertuj(transakcije[0], eur, "EUR");
		Transakcija.konvertuj(transakcije[1], chf, "CHF");
		Transakcija.konvertuj(transakcije[2], cad, "CAD");

		JSONServis.jsonNizUFajl(transakcije, "ostale_transakcije.json");

	}

}