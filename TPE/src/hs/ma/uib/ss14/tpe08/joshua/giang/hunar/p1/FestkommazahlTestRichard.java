package hs.ma.uib.ss14.tpe08.joshua.giang.hunar.p1;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit-Testklasse testet die Klasse Festkommazahl.
 * 
 * @author Marc Langhorst
 * @author Richard Lorenz
 * @author Dennis Messer
 * @version 1.2, 01/04/14
 */
public class FestkommazahlTestRichard {

	private Festkommazahl a;
	private Festkommazahl b;
	private Festkommazahl c;
	private Festkommazahl d;
	private Festkommazahl e;
	private Festkommazahl f;

	/**
	 * Stelle einen Testfall mit sechs Festkommazahlen auf, mit welchen die
	 * Methoden der Klasse <code>Festkommazahl</code> inklusive Rand- und
	 * Problemwerte getestet werden kˆnnen.
	 */
	protected void setUp() {
		a = new Festkommazahl(100L, 0L, 18);
		b = new Festkommazahl(0L, 5L, -5);
		c = new Festkommazahl(0L, 80L, 6);
		d = new Festkommazahl(0L, 0L, 4);
	//	e = new Festkommazahl(0.3564, 6);
	//	f = new Festkommazahl(0.3564, 2);
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(long, long, int)</code> mit dP
	 * = 0
	 */
	@Test
	public void testKonstruktor1() {
		setUp();
		assertEquals(100, a.getVorkomma());
		assertEquals(0, a.getNachkomma());
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(long, long, int)</code> mit
	 * <code>preDP = 0</code>
	 */
	@Test
	public void testKonstruktor2() {
		setUp();
		assertEquals(0, c.getVorkomma());
		assertEquals(80, c.getNachkomma());
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(double, long)</code> mit
	 * <code>preDP = 0</code>
	 */
	@Test
	public void testKonstruktor3() {
		setUp();
		assertEquals(0, e.getVorkomma());
		assertEquals(35, e.getNachkomma());
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(long, long, int)</code> mit
	 * <code>preDP = 0</code> und <code>dP = 0</code>
	 */
	@Test
	public void testKonstruktor4() {
		setUp();
		assertEquals(0, d.getVorkomma());
		assertEquals(0, d.getNachkomma());
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(double, long)</code> mit
	 * <code>preDP = 0</code> auf korrektes ¸bernehmen von nur 2
	 * Nachkommastellen. Die Stellen sollen lediglich abgeschnitten werden.
	 */
	@Test
	public void testKonstruktor5() {
		setUp();
		assertEquals(0, f.getVorkomma());
		assertEquals(35, f.getNachkomma());
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(long, long, int)</code>.
	 * Negativen Werte als aktuelle Parameter sollen eine Fehlermeldung liefern.
	 */
	@Test
	public void testKontruktorNeg1() {
		try {
			Festkommazahl g = new Festkommazahl(-2, 0, 2);
			fail("Festkommazahl(-2, 0) should throw IllegalArgumentException");
		} catch (IllegalArgumentException expected) {
		}
	}

	/**
	 * Test des Konstruktors <code>Festkommazahl(long, long)</code>. Negative
	 * Werte als aktuelle Parameter sollen eine Fehlermeldung liefern.
	 */
	@Test
	public void testKontruktorNeg2() {
		try {
			Festkommazahl g = new Festkommazahl(0, -4);
			fail("Festkommazahl(0, -4) should throw IllegalArgumentException");
		} catch (IllegalArgumentException expected) {
		}
	}

	/**
	 * Test der Methode <code>addiere(Festkommazahl)</code> mit Standardwerten
	 * inklusive Kommutativgesetz der Addition.
	 */
	@Test
	public void testAddiere1() {
		setUp();
		assertEquals(new Festkommazahl(100, 5, 6).toString(), a.addiere(b).toString());
		assertEquals(new Festkommazahl(100, 5, 6).toString(), b.addiere(a).toString());
	}

	/**
	 * Test der Methode <code>addiere(Festkommazahl)</code> mit Standardwerten
	 * inklusive Kommutativgesetz der Addition.
	 */
	@Test
	public void testAddiere2() {
		setUp();
		assertEquals(new Festkommazahl(0, 85, 6).toString(), b.addiere(c).toString());
		assertEquals(new Festkommazahl(0, 85, 6).toString(), c.addiere(b).toString());
	}

	/**
	 * Test der Methode <code>addiere(Festkommazahl)</code> auf 0,00 + 0,00
	 */
	@Test
	public void testAddiere3() {
		setUp();
		assertEquals(new Festkommazahl(0, 0, 6).toString(), d.addiere(d).toString());
	}

	/**
	 * Test der Methode <code>subtrahiere(Festkommazahl)</code> mit
	 * Standardwerten
	 */
	@Test
	public void testSubtrahiere1() {
		setUp();
		assertEquals(new Festkommazahl(99, 95, 6).toString(), a.subtrahiere(b).toString());
	}

	/**
	 * Test der Methode <code>subtrahiere(Festkommazahl)</code> mit
	 * Standardwerten
	 */
	@Test
	public void testSubtrahiere2() {
		setUp();
		assertEquals(new Festkommazahl(0, 75, 6).toString(), c.subtrahiere(b).toString());
	}

	/**
	 * Test der Methode <code>multipliziere(Festkommazahl)</code> mit
	 * Standardwerten inklusive Kommutativgesetz der Multiplikation.
	 */
	@Test
	public void testMultipliziere1() {
		setUp();
		assertEquals(new Festkommazahl(5, 0, 6).toString(), a.multipliziere(b).toString());
		assertEquals(new Festkommazahl(5, 0, 6).toString(), b.multipliziere(a).toString());
	}

	/**
	 * Test der Methode <code>multipliziere(Festkommazahl)</code> mit
	 * Standardwerten inklusive Kommutativgesetz der Multiplikation.
	 */
	@Test
	public void testMultipliziere2() {
		setUp();
		assertEquals(new Festkommazahl(0, 4, 6).toString(), c.multipliziere(b).toString());
		assertEquals(new Festkommazahl(0, 4, 6).toString(), b.multipliziere(c).toString());
	}

	/**
	 * Test der Methode <code>multipliziere(Festkommazahl)</code> auf
	 * Multiplikation mit 0,00
	 */
	@Test
	public void testMultipliziere3() {
		setUp();
		assertEquals(new Festkommazahl(0, 0, 6).toString(), d.multipliziere(d).toString());
	}

	/**
	 * Test der Methode <code>multipliziere(double)</code> mit Standardwerten
	 */
	@Test
	public void testMultipliziereDouble1() {
		setUp();
		assertEquals(new Festkommazahl(2, 0, 6).toString(), c.multipliziere(2.5).toString());
	}

	/**
	 * Test der Methode <code>multipliziere(double)</code> mit Standardwerten
	 */
	@Test
	public void testMultipliziereDouble2() {
		setUp();
		assertEquals(new Festkommazahl(50, 0, 6), a.multipliziere(0.5));
	}

	/**
	 * Test der Methode <code>multipliziere(double)</code> auf Multiplikation
	 * mit 0,00
	 */
	@Test
	public void testMultipliziereDouble3() {
		setUp();
		assertEquals(new Festkommazahl(0, 0, 6).toString(), a.multipliziere(0.0).toString());
	}

	/**
	 * Test der Methode <code>dividiere(double)</code> mit Standardwerten
	 */
	@Test
	public void testDividiere1() {
		setUp();
		assertEquals(new Festkommazahl(20, 0, 6).toString(), a.dividieren(5.0).toString());
	}

	/**
	 * Test der Methode <code>dividiere(double)</code> mit Standardwerten
	 */
	@Test
	public void testDividiere2() {
		setUp();
		assertEquals(new Festkommazahl(4, 0, 6).toString(), c.dividieren(0.2).toString());
	}

	/**
	 * Test der Methode <code>dividiere(double)</code> mit Dividend = 0
	 */
	@Test
	public void testDividiere3() {
		setUp();
		assertEquals(new Festkommazahl(0, 0, 6).toString(), d.dividieren(5.0).toString());
	}

	/**
	 * Test der Methode <code>dividiere(double)</code>. Division durch 0,00 soll
	 * eine Fehlermeldung liefern.
	 */
	@Test
	public void testDividiere4() {
		setUp();
		try {
			a.dividieren(0.0).toString();
			fail("dividiere(0.0) should throw IllegalArgumentException");
		} catch (IllegalArgumentException expected) {
		}
	}

	/**
	 * Test der Methode <code>prozent(double)</code> mit Standardwerten
	 */
	@Test
	public void testProzent1() {
		setUp();
		assertEquals(new Festkommazahl(120, 54, 6).toString(), a.prozent(120.54).toString());
	}

	/**
	 * Test der Methode <code>prozent(double)</code> mit Standardwerten
	 */
	@Test
	public void testProzent2() {
		setUp();
		assertEquals(new Festkommazahl(4, 50, 6).toString(), a.prozent(4.5).toString());
	}

	/**
	 * Test der Methode <code>prozent(double)</code> mit x Prozent von 0
	 */
	@Test
	public void testProzent3() {
		setUp();
		assertEquals(new Festkommazahl(0, 0, 4).toString(), d.prozent(140.5).toString());
	}

	/**
	 * Test der Methode <code>getVorkomma()</code> mit Standardwert
	 */
	@Test
	public void testGetVorkomma1() {
		setUp();
		assertEquals(100, a.getVorkomma());
	}

	/**
	 * Test der Methode <code>getVorkomma()</code> mit Wert 0
	 */
	@Test
	public void testGetVorkomma2() {
		setUp();
		assertEquals(0, c.getVorkomma());
	}

	/**
	 * Test der Methode <code>getNachkomma()</code> mit korrekter Null nach dem
	 * Komma bei zwei Nachkommastellen
	 */
	@Test
	public void testGetNachkomma1() {
		setUp();
		assertEquals(5, b.getNachkomma());
	}

	/**
	 * Test der Methode <code>getNachkomma()</code> mit nur einer
	 * Nachkommastelle
	 */
	@Test
	public void testGetNachkomma2() {
		setUp();
		assertEquals(80, c.getNachkomma());
	}

	/**
	 * Test der Methode <code>toString()</code> auf korrekte
	 * Nachkommadarstellung bei 0
	 */
	@Test
	public void testToString1() {
		setUp();
		assertEquals("100,00", a.toString());
	}

	/**
	 * Test der Methode <code>toString()</code> auf korrekte Vor- und
	 * Nachkommadarstellung bei einer 0 nach dem Komma
	 */
	@Test
	public void testToString2() {
		setUp();
		assertEquals("0,05", b.toString());
	}

	/**
	 * Test der Methode <code>toString()</code> auf korrekte Vor- und
	 * Nachkommadarstellung bei einer Ziffer > 0 hinter dem Komma
	 */
	@Test
	public void testToString3() {
		setUp();
		assertEquals("0,80", c.toString());
	}

	/**
	 * Test der Methode <code>toString()</code> auf korrekte Darstellung der
	 * Zahl 0,00
	 */
	@Test
	public void testToString4() {
		setUp();
		assertEquals("0,00", d.toString());
	}

	/**
	 * Test der Methode <code>toString()</code> mit Standardwert
	 */
	@Test
	public void testToString5() {
		setUp();
		assertEquals("0,35", e.toString());
	}

	/**
	 * Test der Methode <code>getAsDouble()</code> mit Standardwert
	 */
	@Test
	public void testGetAsDouble1() {
		setUp();
		assertEquals(100.0, a.getAsDouble(), 1E-6);
	}

	/**
	 * Test der Methode <code>getAsDouble()</code> mit 0 als erster
	 * Nachkommastelle
	 */
	@Test
	public void testGetAsDouble2() {
		setUp();
		assertEquals(0.05, b.getAsDouble(), 1E-6);
	}

	/**
	 * Test der Methode <code>getAsDouble()</code> mit derZahl 0,00
	 */
	@Test
	public void testGetAsDouble3() {
		setUp();
		assertEquals(0.0, d.getAsDouble(), 1E-6);
	}

	/**
	 * Test der Methode <code>getAsDouble()</code> mit Standardwert
	 */
	@Test
	public void testGetAsDouble4() {
		setUp();
		assertEquals(0.35, e.getAsDouble(), 1E-6);
	}

	/**
	 * Test der Methode <code>equals(Object)</code>. Die Methode wird bei jedem
	 * <code>assertEquals(Object, Object)</code> der anderen Unit-Tests implizit
	 * mit ¸berpr¸ft, daher hier nur der Test auf Werte vom Typ
	 * <code>double</code>
	 */
	@Test
	public void testEqualsDouble1() {
		setUp();
		assertTrue(a.equals(100.0));
	}

	/**
	 * Test der Methode <code>equals(Object)</code>. Die Methode wird bei jedem
	 * <code>assertEquals(Object, Object)</code> der anderen Unit-Tests implizit
	 * mit ¸berpr¸ft, daher hier nur der Test auf Werte vom Typ
	 * <code>double</code>
	 */
	@Test
	public void testEqualsDouble2() {
		setUp();
		assertTrue(b.equals(0.05));
	}

	/**
	 * Test der Methode <code>equals(Object)</code>. Die Methode wird bei jedem
	 * <code>assertEquals(Object, Object)</code> der anderen Unit-Tests implizit
	 * mit ¸berpr¸ft, daher hier nur der Test auf Werte vom Typ
	 * <code>double</code>
	 */
	@Test
	public void testEqualsDouble3() {
		setUp();
		assertTrue(c.equals(0.8));
	}

	/**
	 * Test der Methode <code>equals(Object)</code>. Die Methode wird bei jedem
	 * <code>assertEquals(Object, Object)</code> der anderen Unit-Tests implizit
	 * mit ¸berpr¸ft, daher hier nur der Test auf Werte vom Typ
	 * <code>double</code>
	 */
	@Test
	public void testEqualsDouble4() {
		setUp();
		assertTrue(e.equals(0.3564));
	}

	/**
	 * Test der Klassenmethode <code>parse()</code> zum Erstellen einer
	 * Festkommazahl aus einem String. Test auf korrekte Zuweisung der
	 * Nachkommastellen.
	 */
	/*
	 * @Test public void testParse1() { setUp(); assertEquals(a,
	 * Festkommazahl.parse("100,00")); }
	 * 
	 * /** Test der Klassenmethode <code>parse()</code> zum Erstellen einer
	 * Festkommazahl aus einem String. Test auf korrekte Zuweisung der Vor- und
	 * Nachkommastellen bei nur einer 0 direkt nach dem Komma.
	 */
	/*
	 * @Test public void testParse2() { setUp(); assertEquals(b,
	 * Festkommazahl.parse("0,05")); }
	 * 
	 * /** Test der Klassenmethode <code>parse()</code> zum Erstellen einer
	 * Festkommazahl aus einem String. Test auf korrekte Zuweisung des
	 * Attributes <code>factor</code>.
	 */
	/*
	 * @Test public void testParse3() { setUp();
	 * assertEquals(c.parse("0,800000").toString()); }
	 * 
	 * /** Test der Klassenmethode <code>parse()</code> zum Erstellen einer
	 * Festkommazahl aus einem String. Test auf korrekte Zuweisung der Zahl
	 * 0,00.
	 */
	/*
	 * @Test public void testParse4() { setUp();
	 * assertEquals(d.parse("0,00").toString()); }
	 */

}
