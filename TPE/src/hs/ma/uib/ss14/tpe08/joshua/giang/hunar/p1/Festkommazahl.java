package hs.ma.uib.ss14.tpe08.joshua.giang.hunar.p1;

import java.text.DecimalFormat;

import java.util.*;

/**
 * Diese Klasse soll exakte Berechnungen durchführen ohne Rundungsfehler. Obwohl
 * immer nur zwei Nachkommastellen ausgegeben werden rechnet unser Programm
 * internen mit mehr Nachkommastellen um somit exakte Ergebnisse zu erzielen.
 * 
 * @autor Giang Pham
 * @author Joshua Barsoum
 * @author Hunar Mawlod
 * @version 1.6.2
 * 
 */

public class Festkommazahl {

	private long vorKomma;
	private long nachKomma;
	private final int nachKommastellen;
	private long zahl;

	/**
	 * Konstruktor, der zur Uebergabe mit der Genauigkeit gilt. Wenn eine Zahl
	 * ohne Genauigkeit geschickt wird, wirds auf vier gesetzt
	 * 
	 * @param zahl
	 * 
	 */

	protected Festkommazahl(long zahl) {
		this.zahl = zahl;
		this.nachKommastellen = 4;
	}

	/**
	 * Konstruktor, der die Genauigkeiten bei eingegebenen nachKommastellen
	 * anpasst.
	 * 
	 * @param zahl
	 *            ist unsere Festkommazahl als long
	 * @param nachKommastellen
	 *            ist die Genauigkeit
	 */

	protected Festkommazahl(long zahl, int nachKommastellen) {
		this.zahl = zahl;

		if (nachKommastellen < 2) {
			nachKommastellen = 2;
		} else if (nachKommastellen > 6) {
			nachKommastellen = 6;
		}
		this.nachKommastellen = nachKommastellen;

	}

	/**
	 * Konstruktor, der die Genauigkeit beim anlegen einer Festkommazahl auf 4
	 * festlegt
	 * 
	 * @param vorKomma
	 *            Wert vor dem Komma
	 * 
	 * @param nachKomma
	 *            Wert nach dem Komma
	 * 
	 */

	protected Festkommazahl(long vorKomma, long nachKomma) {
		this(vorKomma, nachKomma, 4);
	}

	/**
	 * Konstruktor und Berechnung unserer long Zahl
	 * 
	 * @param vorKomma
	 *            Wert vor dem Komma
	 * @param nachKomma
	 *            Wert nach dem Komma
	 * @param nachKommastellen
	 *            ist die Genauigkeit
	 */

	protected Festkommazahl(long vorKomma, long nachKomma, int nachKommastellen) {
		this.vorKomma = vorKomma;
		this.nachKomma = nachKomma;

		if (nachKommastellen < 2) {
			nachKommastellen = 2;
		} else if (nachKommastellen > 6) {
			nachKommastellen = 6;
		}
		this.nachKommastellen = nachKommastellen;
		{
			// Bsp: 11*10^4 + 11*10^4-2, -2 wegen Voraussetzung zweiteZahl muss
			// 2 Stellen besitzen

			zahl = (long) ((vorKomma * Math.pow(10, 2) + nachKomma) * Math.pow(
					10, nachKommastellen - 2));

		}
	}

	/**
	 * Gibt den Wert vor dem Komma zurueck
	 * 
	 * @return Wert vor dem Komma
	 */

	protected long getVorkomma() {
		return this.vorKomma;
	}

	/**
	 * Gibt den Wert nach dem Komma zurueck
	 * 
	 * @return Wert nach dem Komma
	 */
	protected long getNachkomma() {
		return this.nachKomma;

	}

	/**
	 * Diese Methode addiert zwei Festkommazahlen miteinander. Wenn wir
	 * unterschiedliche Genauigkeiten haben rufen wir die Methode
	 * <code>samePrecision()<code> auf und die passt dann die Genauigkeiten an.
	 * 
	 * @param o
	 *            zweite uebergebene Festkommazahl
	 * @return die addierte Festkommazahl, Rueckgabe als Festkommazahl
	 */

	protected Festkommazahl addiere(Festkommazahl o) {
		if (this.nachKommastellen != o.nachKommastellen) {
			int precision = samePrecision(o);
			long x = berechneX(o, precision);
			long y = berechneY(precision);
			long e = y + x;
			return new Festkommazahl(e, precision);
		} else {
			long e = this.zahl + o.zahl;
			return new Festkommazahl(e, nachKommastellen);
		}
	}

	/**
	 * Diese Methode subtrahiert zwei Festkommazahlen voneinander. Wenn wir
	 * unterschiedliche Genauigkeiten haben rufen wir die Methode
	 * <code>samePrecision()</code> auf und die passt dann die Genauigkeiten an.
	 * 
	 * @param o
	 *            die zweite Festkommazahl, die wir zum subtrahieren nutzen
	 * @return die subtrahierte Festkommazahl, Rueckgabe als Festkommazahl
	 */
	protected Festkommazahl subtrahiere(Festkommazahl o) {
		if (this.nachKommastellen != o.nachKommastellen) {
			int precision = samePrecision(o);
			long x = berechneX(o, precision);
			long y = berechneY(precision);
			long e = y - x;
			return new Festkommazahl(e, precision);
		} else {
			long e = this.zahl - o.zahl;
			return new Festkommazahl(e, nachKommastellen);
		}
	}

	/**
	 * Diese Methode multipliziert zwei Festkommazahlen miteinander. Wenn wir
	 * unterschiedliche Genauigkeiten haben rufen wir die Methode
	 * <code>samePrecision()</code> auf und die passt dann die Genauigkeiten an.
	 * 
	 * 
	 * @param o
	 *            , die zweite Festkommazahl
	 * @return die mulitiplizierte Festkommazahl, natuerlich auch als
	 *         Festkommazahl
	 */
	protected Festkommazahl multipliziere(Festkommazahl o) {

		if (this.nachKommastellen != o.nachKommastellen) {
			int precision = samePrecision(o);
			long x = berechneX(o, precision);
			long y = berechneY(precision);
			long e = y * x;
			e = (long) (e / (Math.pow(10, precision)));
			return new Festkommazahl(e, precision);
		} else {
			long e = this.zahl * o.zahl;
			e = (long) (e / (Math.pow(10, nachKommastellen)));
			return new Festkommazahl(e, nachKommastellen);
		}
	}

	/**
	 * Diese Methode multipliziert unsere Festkommazahl mit einem double Wert
	 * den wir als Parameter übergeben.
	 * 
	 * @param zahl
	 *            unser eingegebener double Wert
	 * @return unseren errechneten Wert als Festkommazahl
	 */
	protected Festkommazahl multipliziere(double zahl) {
		long e = (long) (this.zahl * zahl);
		if (this.nachKommastellen != 4) {
			return new Festkommazahl(e, this.nachKommastellen);
		}
		return new Festkommazahl(e);

	}

	/**
	 * Diese Methode dividiert unsere Festkommazahl mit einem double Wert den
	 * wir als Parameter übergeben.
	 * 
	 * @param zahl
	 *            unser double Wert
	 * @return gibt den errechneten Wert als Festkommazahl zurueck
	 */
	protected Festkommazahl dividieren(double zahl) {
		long e = (long) (this.zahl / zahl);
		if (nachKommastellen != 4) {
			return new Festkommazahl(e, nachKommastellen);
		}
		return new Festkommazahl(e);

	}

	/**
	 * Diese Methode berechnet einen prozent Wert (den wir vorher als Parameter
	 * übergeben) von unserer Festkommazahl aus.
	 * 
	 * @param prozentzahl
	 *            unser Parameter der einen prozentualen Wert übergibt
	 * @return gibt einen prozentualen Anteil von unserer Festkommazahl zurueck
	 */

	protected Festkommazahl prozent(double prozentzahl) {
		long e = (long) ((prozentzahl * this.zahl) / 100);
		if (this.nachKommastellen != 4) {
			return new Festkommazahl(e, nachKommastellen);
		}
		return new Festkommazahl(e);
	}

	/**
	 * Diese Methode berechnet intern / bzw. wandelt unsere Festkommazahl intern
	 * in einen double. Man kann diese Methode aufrufen, damit man den double
	 * Wert sieht
	 * 
	 * @return double Wert
	 */
	protected double getAsDouble() {
		double d = this.zahl / (Math.pow(10, nachKommastellen - 2)) / 100;

		d = 100 * d;
		d = Math.round(d);
		d = d / 100.0;
		return d;

	}

	/**
	 * Unsere toString Methode gibt unseren Wert als String zurück
	 * 
	 * @return unseren eingegebenen Wert als String
	 */

	public String toString() {
		DecimalFormat f = new DecimalFormat("#0.00");
		String s = String.valueOf(f.format(getAsDouble()));
		return s;
	}

	/**
	 * Erzeugen einer neuen Festkommazahl aus einem String den wir vorher
	 * uebergeben. Dazu nutzen wir <code>parseDouble(String s)</code>.
	 * 
	 * 
	 * @param zeichen
	 *            uebergebener String
	 * @return gibt unseren Eingabewert als neue Festkommazahl zurück
	 */
	protected Festkommazahl parse(String zeichen) {
		long d = (long) parseDouble(zeichen);
		return new Festkommazahl(d);
	}

	/**
	 * Macht aus unserem String ein double
	 * 
	 * @param s
	 *            unsere Eingabewert als String
	 * @return unseren Eingabewert als double
	 */
	protected double parseDouble(String s) {
		double d = Double.valueOf(s);
		return d;
	}

	/**
	 * Vergleichen zweier Festkommazahlen auf Gleichheit. Wir implentieren eine
	 * eigene equals Methode und überschreiben die equals Methode von der Object
	 * Klasse. Verwendet die überschriebene <code>hashCode()</code> Methode um
	 * schneller Objekte miteinander zu vergleichen und den Vergleichsaufwand zu
	 * verringen.
	 * 
	 * 
	 * @param obj
	 *            vom Typ Object
	 * @return true oder false, je nachdem was zutrifft
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj.getClass() == this.getClass()) {
			Festkommazahl f = (Festkommazahl) obj;// typecast Object zu
													// Festkommazahl
			if (this.zahl == f.zahl) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Errechnen der Hashwerte. Da die equals Methode überschrieben wurde, muss
	 * auch die hashCode Methode von der Object Klasse überschrieben werden. Mit
	 * Hashwerten kann man so viel schneller Objekte miteinander vergleichen, da
	 * es nur ein integer Wert zurückgibt.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (zahl ^ (zahl >>> 32));
		result = prime * result
				+ (int) (nachKommastellen ^ (nachKommastellen >>> 32));
		return result;
	}

	/**
	 * Diese Methode bringt unterschiedliche Genauigkeiten auf die selbe, d.h.
	 * sie bekommt die zweite Festkommazahl als Parameter, vergleicht die Anzahl
	 * der Genauigkeiten und dann setzt sie diese gleich.
	 * 
	 * @param o
	 *            unsere zweite Festkommazahl
	 * @return gibt die Genauigkeit zurueck fuer die weitere Berechnungen
	 */
	protected int samePrecision(Festkommazahl o) {
		if (this.nachKommastellen > o.nachKommastellen) {
			return this.nachKommastellen;
		} else {
			return o.nachKommastellen;
		}
	}

	/**
	 * Diese Methode berechnet den Long Wert und gleicht somit die Genauigkeit
	 * des Wertes für die Weiterberechnung an, sobald eine unterschiedliche
	 * Genauigkeit festgestellt wurde.
	 * 
	 * @param o
	 *            unsere zweite Festkommazahl
	 * @param precision
	 *            ist die Genauigkeit, die von <code>samePrecision</code>
	 *            ermittelt wurde.
	 * @return x ist unser Ergebnis; der veraenderte Wert mit neuer Genauigkeit.
	 */
	protected long berechneX(Festkommazahl o, int precision) {
		long x = (long) (o.zahl * Math.pow(10, precision - o.nachKommastellen));
		return x;
	}

	/**
	 * Diese Methode berechnet den Long Wert und gleicht somit die Genauigkeit
	 * des Wertes für die Weiterberechnung an, sobald eine unterschiedliche
	 * Genauigkeit festgestellt wurde.
	 * 
	 * @param precision
	 *            ist die Genauigkeit, die von <code>samePrecision</code>
	 *            ermittelt wurde.
	 * @return y ist unser Ergebnis; der veraenderte Wert mit neuer Genauigkeit.
	 */
	protected long berechneY(int precision) {
		long y = (long) (this.zahl * Math.pow(10, precision
				- this.nachKommastellen));
		return y;
	}
}