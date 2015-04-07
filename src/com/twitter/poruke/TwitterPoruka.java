package com.twitter.poruke;

/**
 * Ova klasa predstavlja twitter poruku
 * @author Andrej
 *
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika twitter poruka
	 */
	private String korisnik;
	/**
	 * Tekst twitter poruke
	 */
	private String poruka;
	/**
	 * Ova metoda vraca korisnika poruke
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Ova metoda postavlja ime korisnika
	 * @param korisnikovo ime
	 * @throws java.lang.RuntimeException u slucaju kada je Ime korisnika null ili prazan string
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
							this.korisnik = korisnik;
	}
	/**
	 * Ova metoda vraca tekst, odnosno sadrzaj twitter poruke
	 * @return Tekst poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	/**
	 * Ova metoda pravi sadrzaj twitter poruke
	 * @param poruka
	 * @throws java.lang.RuntimeException u slucaju kada je poruka null ili ako je poruka duza od dozvoljene duzine
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Ova metoda vraca ime korisnika i tekst poruke
	 * @return korisnik i sadrzaj poruke
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
