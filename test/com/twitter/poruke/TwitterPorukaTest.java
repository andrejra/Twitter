/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Andrej
 *
 */
public class TwitterPorukaTest {
	TwitterPoruka twp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	twp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	twp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		twp.setKorisnik("Zoran Sumadinac");
		assertEquals("Zoran Sumadinac", twp.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		twp.setKorisnik(null);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		twp.setKorisnik("");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		twp.setPoruka("Hello world");
		assertEquals("Hello world",twp.getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		twp.setPoruka(null);
	}
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPoruka140Karaktera() {
		String por="Vise od 140 karaktera.";
		for (int i = 0; i < 7; i++) {
			por= por + "Jos vise od 140 karaktera. ";
		}
		twp.setPoruka(por);
		assertEquals(por, twp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		twp.setKorisnik("ime");
		twp.setPoruka("poruka");
		assertEquals("KORISNIK:"+"ime"+" PORUKA:"+"poruka", "KORISNIK:"+twp.getKorisnik()+" PORUKA:"+twp.getPoruka());
	}

}
