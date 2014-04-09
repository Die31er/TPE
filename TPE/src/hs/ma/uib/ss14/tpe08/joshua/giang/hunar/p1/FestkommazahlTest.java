package hs.ma.uib.ss14.tpe08.joshua.giang.hunar.p1;

import org.junit.Test;

import static org.junit.Assert.*;

public class FestkommazahlTest {
	/**
	 * JUnit Testklasse, die unsere Klasse Festkommazahl testet.
	 * 
	 * @author Giang Pham
	 * @author Joshua Barsoum
	 * @author Hunar Mawlod
	 * @version 1.5
	 */

	Festkommazahl eins = new Festkommazahl(5L, 45L, 9);
	Festkommazahl zwei = new Festkommazahl(6L, 45L, 5);
	Festkommazahl drei = new Festkommazahl(0L, 9L, 2);
	Festkommazahl vier = new Festkommazahl(123L, 23L, 3);
	Festkommazahl fuenf = new Festkommazahl(44L, 13L, 4);
	Festkommazahl sechs = new Festkommazahl(10L, 0L);
	Festkommazahl sieben = new Festkommazahl(122L, 23L, 3);

	/**
	 * Test der Methode <code>addiere(Festkommazahl)</code> mit
	 * unterschiedlichen Genauigkeiten.
	 */
	@Test
	public void testAddition() {
		assertEquals(new Festkommazahl(11L, 90L, 6), eins.addiere(zwei));
		assertEquals(new Festkommazahl(11L, 90L, 6).getAsDouble(), eins
				.addiere(zwei).getAsDouble(), 0);

	}

	/**
	 * Test der Methode <code>addiere(Festkommazahl)</code>.
	 */
	@Test
	public void testAddition2() {
		assertEquals(new Festkommazahl(11L, 90L, 6), eins.addiere(zwei));

	}

	/**
	 * Test der Methode <code>addiere(Festkommazahl)</code> mit gleicher
	 * Genauigkeit.
	 */
	@Test
	public void testAddition3() {
		assertEquals(new Festkommazahl(54L, 13L, 4), fuenf.addiere(sechs));
	}

	/**
	 * Test der Methode <code>subtrahiere(Festkommazahl)</code> mit
	 * unterschiedlichen Genauigkeiten.
	 */
	@Test
	public void testSubtrahiere() {
		assertEquals(new Festkommazahl(1L, 00L, 6), zwei.subtrahiere(eins));
	}

	/**
	 * Test der Methode <code>subtrahiere(Festkommazahl)</code> mit
	 * unterschiedlichen Genauigkeiten.
	 */
	@Test
	public void testSubtrahiere1() {
		assertEquals(new Festkommazahl(79L, 10L, 4), vier.subtrahiere(fuenf));
	}

	/**
	 * Test der Methode <code>subtrahiere(Festkommazahl)</code> mit gleicher
	 * Genauigkeiten.
	 */
	@Test
	public void testSubtrahiere2() {
		assertEquals(new Festkommazahl(1L, 0L, 3), vier.subtrahiere(sieben));
	}

	/**
	 * Test der Methode <code>multiplizere(Festkommazahl)</code> mit
	 * verschiedenen Genauigkeiten.
	 */
	@Test
	public void testMultipliziere() {
		assertEquals(new Festkommazahl(11L, 9L, 3), drei.multipliziere(vier));
	}

	/**
	 * Test der Methode <code>multiplizere(Festkommazahl)</code> mit gleicher
	 * Genauigkeiten.
	 */
	@Test
	public void testMultiplizere1() {
		assertEquals(new Festkommazahl(441L, 30L), sechs.multipliziere(fuenf));
	}

	/**
	 * Testet die Methode <code>multipliziere(double zahl)</code>.
	 */
	@Test
	public void testMultipliziereDouble() {
		assertEquals(new Festkommazahl(5L, 45L, 6), eins.multipliziere(1));
	}

	/**
	 * Testet die Methode <code>multipliziere(double zahl)</code>.
	 */
	@Test
	public void testMultipliziereDouble1() {
		assertEquals(new Festkommazahl(6L, 45L, 5), zwei.multipliziere(1));

	}

	/**
	 * Testet die Methode <code>multipliziere(double zahl)</code>.
	 */
	@Test
	public void testMultipliziereDouble2() {
		assertEquals(new Festkommazahl(66L, 19L, 6).getAsDouble(), fuenf
				.multipliziere(1.5).getAsDouble(), 0);
	}

	/**
	 * Testet die Methode <code>dividieren(double zahl)</code>.
	 */
	@Test
	public void testDividieren() {
		assertEquals(new Festkommazahl(1L, 0L, 6), eins.dividieren(5.45));
	}

	/**
	 * Testet die Methode <code>dividieren(double zahl)</code>.
	 */
	@Test
	public void testDividieren1() {
		assertEquals(new Festkommazahl(58L, 84L), fuenf.dividieren(0.75));
	}

	/**
	 * Testet die Methode <code>dividieren(double zahl)</code>.
	 */
	@Test
	public void testDividieren2() {
		assertEquals(new Festkommazahl(10L, 0L), sechs.dividieren(1));
	}

	/**
	 * Testet die Methode <code>prozent(double zahl)</code>.
	 */
	@Test
	public void testProzent() {
		assertEquals(new Festkommazahl(2L, 73L).getAsDouble(), eins.prozent(50)
				.getAsDouble(), 0.1);
	}

	/**
	 * Testet die Methode <code>prozent(double zahl)</code>.
	 */
	@Test
	public void testProzent1() {
		assertEquals(new Festkommazahl(5L, 0L).getAsDouble(), sechs.prozent(50)
				.getAsDouble(), 0.1);
	}

	/**
	 * Testet die Methode <code>prozent(double zahl)</code>.
	 */
	@Test
	public void testProzent2() {
		assertEquals(new Festkommazahl(0L, 1L).getAsDouble(), vier
				.prozent(0.01).getAsDouble(), 0.1);
	}

	/**
	 * Testet die Methode <code>getVorkomma()</code>.
	 */
	@Test
	public void testGetVorkomma() {
		assertEquals(5, eins.getVorkomma());
	}

	/**
	 * Testet die Methode <code>getVorkomma()</code>.
	 */
	@Test
	public void testGetVorkomma1() {
		assertEquals(122, sieben.getVorkomma());
	}

	/**
	 * Testet die Methode <code>getVorkomma()</code>.
	 */
	@Test
	public void testGetVorkomma2() {
		assertEquals(123, vier.getVorkomma());
	}

	/**
	 * Testet die Methode <code>getNachkomma</code>.
	 */
	@Test
	public void testNachVorkomma() {
		assertEquals(45, eins.getNachkomma());
	}

	/**
	 * Testet die Methode <code>getNachkomma</code>.
	 */
	@Test
	public void testNachVorkomma1() {
		assertEquals(0, sechs.getNachkomma());
	}

	/**
	 * Testet die Methode <code>getNachkomma</code>.
	 */
	@Test
	public void testNachVorkomma2() {
		assertEquals(23, vier.getNachkomma());
	}

	/**
	 * Testet die Methode <code>toString()</code>.
	 */
	@Test
	public void testToString() {
		assertEquals("0,09", drei.toString());
	}

	/**
	 * Testet die Methode <code>toString()</code>.
	 */
	@Test
	public void testToString1() {
		assertEquals("44,13", fuenf.toString());
	}

	/**
	 * Testet die Methode <code>toString()</code>.
	 */
	@Test
	public void testToString2() {
		assertEquals("122,23", sieben.toString());
	}

	/**
	 * Testet die Methode <code>getAsDouble()</code>.
	 */
	@Test
	public void testGetAsDouble() {
		assertEquals(5.45, eins.getAsDouble(), 0);
	}

	/**
	 * Testet die Methode <code>getAsDouble()</code>.
	 */
	@Test
	public void testGetAsDouble1() {
		assertEquals(122.23, sieben.getAsDouble(), 0);
	}

	/**
	 * Testet die Methode <code>getAsDouble()</code>.
	 */
	@Test
	public void testGetAsDouble2() {
		assertEquals(0.09, drei.getAsDouble(), 0);
	}

	/**
	 * Testet die Methode <code>equals(Festkommazahl)</code> auf Gleichheit.
	 */
	@Test
	public void testEquals() {
		assertEquals(false, eins.equals(zwei));
	}

	/**
	 * Testet die Methode <code>equals(Festkommazahl)</code> auf Gleichheit.
	 */
	@Test
	public void testEquals1() {
		assertEquals(false, sechs.equals(sieben));
	}

	/**
	 * Testet die Methode <code>equals(Festkommazahl)</code> auf Gleichheit.
	 */
	@Test
	public void testEquals2() {
		assertEquals(false, zwei.equals(drei));
	}

	/**
	 * Testet die Methode <code>equals(Festkommazahl)</code> auf Gleichheit.
	 */
	@Test
	public void testEquals3() {
		assertEquals(true, zwei.equals(new Festkommazahl(6L, 45L, 5)));
	}

	/**
	 * Testet die Methode <code>parse(zeichen)</code>
	 */
	@Test
	public void testParse() {
		assertEquals("19,37", eins.parse("193700").toString());
	}

	/**
	 * Testet die Methode <code>parse(zeichen)</code>
	 */
	@Test
	public void testParse1() {
		assertEquals("1,22", eins.parse("12200").toString());
	}

	/**
	 * Testet die Methode <code>parse(zeichen)</code>
	 */
	@Test
	public void testParse2() {
		assertEquals("0,87", eins.parse("08700").toString());
	}

}
