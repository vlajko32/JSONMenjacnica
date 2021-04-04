package servis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import transakcija.Transakcija;


public class APIServis {

	public static final String BASE_URL = "http://api.currencylayer.com/";
	public static final String ACCESS_KEY = "e4f3be759580705384816b28745d1315";
	public static final String DATUM = "2020-07-24";
	public static HttpURLConnection get(Transakcija t, String valuta) {

		try {

			

			URL url;

			if(valuta != null) {
				 url = new URL(BASE_URL + "live" + "?access_key=" + ACCESS_KEY  + "&date=" + DATUM + "&source=" + t.getIzvornaValuta() + "&currencies=" + t.getKrajnjaValuta());
			}else {
				 url = new URL(BASE_URL + "live" + "?access_key=" + ACCESS_KEY + "&date=" + DATUM + "&source=" + t.getIzvornaValuta());
			}


			HttpURLConnection con = (HttpURLConnection)url.openConnection();

			con.setRequestMethod("GET");

			return con;
		} catch (Exception e) {
			return null;
		}
	}

	public static JsonObject responseToJson(HttpURLConnection con) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			JsonObject res = gson.fromJson(reader, JsonObject.class);
			return res;
		} catch (IOException e) {

			return null;
		}	
	}

}