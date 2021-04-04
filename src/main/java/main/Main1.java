package main;

import java.net.HttpURLConnection;
import java.util.Date;

import com.google.gson.JsonObject;

import servis.APIServis;
import servis.JSONServis;
import transakcija.Transakcija;

public class Main1 {

	public static void main(String[] args) {

		Transakcija t = new Transakcija();
		t.setIzvornaValuta("USD");
		t.setPocetniIznos(97);
		t.setKrajnjaValuta("CAD");
		t.setDatumTransakcije(new Date());

		HttpURLConnection con = APIServis.get(t, t.getKrajnjaValuta());

		JsonObject res = APIServis.responseToJson(con);

		double cad = res.get("quotes").getAsJsonObject().get("USDCAD").getAsDouble();

		Transakcija.konvertuj(t, cad, "CAD");

		JSONServis.jsonUFajl(t, "prva_transakcija.json");





	}

}