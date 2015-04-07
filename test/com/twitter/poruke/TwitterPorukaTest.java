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
	@Test
	public void testSetPoruka() {
		twp.setPoruka("Hello world");
		assertEquals("Hello world",twp.getPoruka());
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
