package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
/**
 * Ova klasa predstavlja Twitter
 * @author Andrej
 *
 */
public class Twitter {
	/**
	 * Lista twitter poruka
	 */
	private LinkedList<TwitterPoruka> poruke =
	new LinkedList<TwitterPoruka>();
	/**
	 * Ova metoda vraca sve twitter poruke
	 * @return listu twitter poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Ova metoda unosi novu poruku u listu poruke
	 * @param korisnik - korisnik/autor poruke
	 * @param poruka - sadrzaj poruke
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Ova metoda vraca niz poruka zadate velicine (maxBroj) koje sadrze trazeni tekst ( tag )	
	 * @param maxBroj - kapacitet niza 
	 * @param tag - tekst koji treba da sadrzi trazena poruka
	 * @return vraca niz twitter poruka zadatog kapaciteta, u kojem svaki clan niza sadrzi odredjeni trazeni tekst
	 * @throws java.lang.RuntimeException u slucaju kada uneti tag nije validan
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
	//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
	 //Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
	//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
	//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
	//Pretrazuju se poruke i traze se one koje sadrze tag.
	//Ako se nadje neka takva, i ako nije prekoracen maxBroj
	//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
	//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
	}
					else break;
	return rezultat;
	}
} 