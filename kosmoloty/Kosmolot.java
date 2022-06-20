
public class Kosmolot {
	String nazwa;
	int predkosc_x;
	int predkosc_y;
	int pozycja_x;
	int pozycja_y;
	int odleglosc;		//Przebyta odleglosc
	
	Kosmolot(String nazwa, int pr_x, int pr_y, int poz_x, int poz_y) {
		this.nazwa = nazwa;
		this.predkosc_x = pr_x;
		this.predkosc_y = pr_y;
		this.pozycja_x = poz_x;
		this.pozycja_y = poz_y;
		this.odleglosc = 0;
	}
}
