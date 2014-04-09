package hs.ma.uib.ss14.tpe08.joshua.giang.hunar.p1;

/**
 * Die Klasse Darlehen, die zur Berechnung des Annuitätendarlehen die Klasse
 * Festkommazahl verwendet.
 * 
 * @author Giang Pham
 * @author Joshua Barsoum
 * @author Hunar Mawlod
 * @version 1.3
 * 
 */

public class Darlehen {
	private Festkommazahl darlehen; // Darlehen, oder auch Restschuld im Jahr 0
	private Festkommazahl pt; // Tilgungssatz
	private Festkommazahl pi; // Zinssatz
	private Festkommazahl rest; // Restschuld

	/**
	 * Konstruktor speichert die uebergebenen Festkommazahlen.
	 * 
	 * @param darlehen
	 *            eingegebener Darlehenwert
	 * @param pi
	 *            eingegebener Prozentsatz
	 * @param pt
	 *            eingegebener Tilgungssatz
	 */
	protected Darlehen(Festkommazahl darlehen, Festkommazahl pi, Festkommazahl pt) {
		this.darlehen = darlehen;
		this.pt = pt;
		this.pi = pi;
		this.rest = darlehen;
	}

	/**
	 * Diese Methode berechnet die Annuitaet. Formel: ((Zinssatz +
	 * Tilgungssatz)/100) * Darlehen.
	 * 
	 * @return erg gibt unsere Annuitaet zurueck
	 */
	protected Festkommazahl berechneAnnuitaet() {
		Festkommazahl erg;
		erg = (pi.addiere(pt).dividieren(100)).multipliziere(darlehen);
		return erg;
	}

	/**
	 * Gibt den Wert Darlehen zurueck.
	 * 
	 * @return this.darlehen gibt unser Darlehen zurueck
	 */
	protected Festkommazahl getDarlehen() {
		return this.darlehen;
	}

	/**
	 * Diese Methode berechnet die Zinsen. Formel: Restschuld * (Zinssatz / 100)
	 * 
	 * @return erg ist unsere Zinswert
	 */
	protected Festkommazahl berechneZinsen() {
		Festkommazahl erg;
		erg = this.rest.multipliziere(pi).dividieren(100);
		return erg;
	}

	/**
	 * Diese Methode berechnet die Tilgung. Sie ruft
	 * <code>berechneAnnuitaet()</code> auf und subtrahiert Zinsen.
	 * 
	 * @param zins
	 *            bekommt unseren Zinswert uebergeben
	 * @return tilgung ist die Differenz zwischen Annuitaet und Zinsen
	 */
	protected Festkommazahl berechneTilgung(Festkommazahl zins) {
		Festkommazahl tilgung;
		tilgung = berechneAnnuitaet().subtrahiere(zins);
		return tilgung;
	}

	/**
	 * Diese Methode berechnet die Restschuld.
	 * 
	 * @param n
	 *            ist die Anzahl der Jahre
	 * @param tilgung
	 *            ist unsere Tilgung die wir in
	 *            <code>berechneTilgung(Festkommazahl zins)</code> berechnen
	 * @return Rueckgabe ist unsere Restschuld
	 */
	protected Festkommazahl berechneRestschuld(int n, Festkommazahl tilgung) {
		n--;
		if (n > 1) {
			rest = (berechneRestschuld(n, tilgung));
			rest = rest.subtrahiere(berechneTilgung(berechneZinsen()));

		}
		if (n == 1) {
			return darlehen;
		}
		return rest;
	}

	/**
	 * Durch den Aufruf unserer Methoden
	 * <code> berechneZinsen(), berechneTilgung(Festkommazahl zins)</code> und 
	 * <code>berechneRestschuld(int n, Festkommazahl tilgung)</code> berechnen wir die
	 * Werte und speichern sie in ein Array, welches wir dann zur Ausgabe
	 * nutzen, somit geben wir ein Array zurueck.
	 * 
	 * 
	 * @param n
	 *            bekommt die Anzahl der Jahre
	 */
	protected void jahresDaten(int n) {
		Object[][] tabelle = new Object[n + 1][4];
		for (int i = 1; i < n + 1; i++) {
			tabelle[i][3] = berechneRestschuld(i + 1,
					berechneTilgung(berechneZinsen()));
			tabelle[i][2] = berechneTilgung(berechneZinsen());
			tabelle[i][1] = berechneZinsen();
			tabelle[i][0] = i;
			for (int j = 0; j < 4; j++) {
				System.out.print(tabelle[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
