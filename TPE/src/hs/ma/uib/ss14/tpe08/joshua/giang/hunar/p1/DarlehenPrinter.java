package hs.ma.uib.ss14.tpe08.joshua.giang.hunar.p1;

/**
 * Diese Klasse erzeugt neue Festkommazahlen, übergibt diese der Klasse Darlehen
 * und ruft die Methode jahresDaten der Klasse Darlehen auf, die die
 * Berechnungen als Tabelle ausgibt.
 * 
 * @author Giang Pham
 * @author Joshua Barsoum
 * @author Hunar Mawlod
 * @version 1.3
 * 
 */

public class DarlehenPrinter {

	public static void main(String[] args) {

		Festkommazahl d1 = new Festkommazahl(200000L, 00L);
		Festkommazahl z1 = new Festkommazahl(3L, 50L);
		Festkommazahl t1 = new Festkommazahl(1L, 50L);

		Festkommazahl d2 = new Festkommazahl(100000L, 00L);
		Festkommazahl z2 = new Festkommazahl(5L, 50L);
		Festkommazahl t2 = new Festkommazahl(3L, 50L);

		Festkommazahl d3 = new Festkommazahl(300000L, 00L);
		Festkommazahl z3 = new Festkommazahl(6L, 00L);
		Festkommazahl t3 = new Festkommazahl(1L, 00L);

		Festkommazahl bd = new Festkommazahl(100000L, 00L);
		Festkommazahl bz = new Festkommazahl(4L, 00L);
		Festkommazahl bt = new Festkommazahl(1L, 00L);

		Darlehen darlehen1 = new Darlehen(d1, z1, t1);
		Darlehen darlehen2 = new Darlehen(d2, z2, t2);
		Darlehen darlehen3 = new Darlehen(d3, z3, t3);
		Darlehen beispiel = new Darlehen(bd, bz, bt);

		beispiel.jahresDaten(10);
		System.out.println();
		darlehen1.jahresDaten(10);
		System.out.println();
		darlehen2.jahresDaten(10);
		System.out.println();
		darlehen3.jahresDaten(10);

	}

}
