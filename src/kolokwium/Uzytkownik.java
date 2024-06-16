package kolokwium;

import java.io.Serializable;

public class Uzytkownik implements Serializable{
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdresEmail() {
		return adresEmail;
	}

	public void setAdresEmail(String adresEmail) throws Exception{
		if(adresEmail.indexOf("@") < 1)
			throw new Exception("Nieprawidlowy adres email");
		this.adresEmail = adresEmail;
	}

	public int getWiek() {
		return wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	private String imie;
	private String nazwisko;
	private String adresEmail;
	private int wiek;
	
	public Uzytkownik(String imie, String nazwisko, String adresEmail, int wiek) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.adresEmail = adresEmail;
		this.wiek = wiek;
	}
	
	public Uzytkownik() {
		this("Jan", "Kowalski", "kowalski@gmail.com", 45);
	}
}
