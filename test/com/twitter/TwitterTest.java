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
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiDve() {
		tw.unesi("Zoran", "Sumadinac");
		tw.unesi("Cara", "Mimi");
		TwitterPoruka por1=new TwitterPoruka();
		TwitterPoruka por2=new TwitterPoruka();
		por1.setKorisnik("Zoran");
		por1.setPoruka("Sumadinac");
		por2.setKorisnik("Cara");
		por2.setPoruka("Mimi");
		assertEquals(por1.toString(), tw.vratiSvePoruke().get(tw.vratiSvePoruke().size()-2).toString());
		assertEquals(por2.toString(), tw.vratiSvePoruke().get(tw.vratiSvePoruke().size()-1).toString());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		tw.unesi("Zoran Sumadinac", "Ja sam najbolji pevac");
		tw.unesi("Cara Mimi", "Ja sam najgori pevac");
		tw.unesi("Petar Petrovic", "Ja nisam pevac");
		TwitterPoruka[] test = tw.vratiPoruke(6,"pevac");
		assertEquals(6 , test.length);
		assertEquals("Ja sam najbolji pevac", test[0].getPoruka());
		assertEquals("Zoran Sumadinac", test[0].getKorisnik());
		assertEquals("Ja sam najgori pevac", test[1].getPoruka() );
		assertEquals("Cara Mimi", test[1].getKorisnik());
		assertEquals(null, test[5]);
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {		
		tw.unesi(null, null);
		tw.vratiPoruke(1, null);
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected=java.lang.RuntimeException.class)
	public void testVratiPorukePrazanString() {		
		tw.unesi("", "");
		tw.vratiPoruke(1, "");
	}
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test 
	public void testVratiPorukeNevalidanMaxBr() {
		TwitterPoruka [] niz = tw.vratiPoruke(-1, "trazeni pojam");
		assertEquals(100,niz.length);
	}
}
