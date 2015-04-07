/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Andrej
 *
 */
public class TwitterTest {
	Twitter tw;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tw = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tw = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		tw.unesi("Zoran", "Sumadinac");
		
		//assertEquals(1, tw.vratiSvePoruke().size());
		assertEquals("Zoran", tw.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("Sumadinac", tw.vratiSvePoruke().get(0).getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		tw.unesi("Zoran Sumadinac", "feat. Cara Mimi - Magija");
		TwitterPoruka twp=new TwitterPoruka();
		twp.setKorisnik("Zoran Sumadinac");
		twp.setPoruka("feat. Cara Mimi - Magija");
		assertEquals("Zoran Sumadinac", tw.vratiSvePoruke().get(0).getKorisnik());
		assertEquals("feat. Cara Mimi - Magija",tw.vratiSvePoruke().get(0).getPoruka());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		tw.unesi("Ime1", "poruka1");
		tw.unesi("Ime2", "poruka2");
		tw.unesi("Ime3", "poruka3");
		tw.unesi("Ime4", "poruka4");
		tw.vratiPoruke(1, "poruka2");
	}

}
