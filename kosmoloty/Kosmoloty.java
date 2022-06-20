import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class Kosmoloty {
	
	public static int odleglosc(int x, int y) {
		return (int)(Math.sqrt(x^2 + y^2));
	}
	
	public static boolean koniecGry() {
		if(uczestnicy.size() == 1 || czas == koniecCzasu) {
			if(uczestnicy.size() == 1) {
				System.out.println(uczestnicy.get(0).nazwa);
			}
			else {
				int bestIdx = 0;	//Indeks najlepszego kosmolotu
				int idx = 0;		//Indeks obecnego kosmolotu
				for(Kosmolot temp : uczestnicy) {
					if(temp.odleglosc > uczestnicy.get(bestIdx).odleglosc) {
						bestIdx = idx;
					}
				}
				System.out.println(uczestnicy.get(bestIdx).nazwa);
			}
			return true;
		}
		else
			return false;
	}
	
	public static int koniecCzasu = 86400;				//Zawody koncza sie po 24 godzinach
	public static int czas = 0;							//Stoper, odmierzajacy czas
	static List<Kosmolot> uczestnicy = new ArrayList<Kosmolot>(); 
	
	public static void main(String args[]) {
		if(args.length != 2) {
			throw new RuntimeException("klops");
		}
		int torusX = Integer.valueOf(args[0]); 	//Wielkosc torusa X
		int torusY = Integer.valueOf(args[1]); 	//Wielkosc torusa Y

		List<String> kordy = new ArrayList<String>();		//Lista przechowujaca polozenie kosmolotow
		
		if(torusX < 1 || torusX > 100000 || torusY < 1 || torusY > 100000) {
			throw new RuntimeException("klops");
		}
		
		String nazwa;							//Zmienne pomocnicze
		int pr_x;
		int pr_y;
		int poz_x;
		int poz_y;
		String kord;
		BufferedReader kosmoloty;
		Scanner input = new Scanner(System.in);
		input.useDelimiter(System.lineSeparator());
		while(input.hasNextLine()) {
			String dane[] = input.nextLine().split(",");
			dane[4] = dane[4].replaceAll("\\r|\\n", " ");
			nazwa = dane[0];
			pr_x = Integer.valueOf(dane[1]);
			pr_y = Integer.valueOf(dane[2]);
			poz_x = Integer.valueOf(dane[3]);
			poz_y = Integer.valueOf(dane[4]);
			if(dane.length != 5 || nazwa.length() > 10 || pr_x < -10000 || pr_x > 10000
					|| pr_y < -10000 || pr_y > 10000 || poz_x < 0
					|| poz_x > (torusX - 1) || poz_y < 0 || poz_y > (torusY - 1)) {
				throw new IllegalArgumentException("klops");
			}
			kord = poz_x + " " + poz_y;
			if(kordy.contains(kord)) {
				throw new IllegalArgumentException("klops");
			}
			kordy.add(kord);
			
			Kosmolot uczestnik = new Kosmolot(nazwa, pr_x, pr_y, poz_x, poz_y);
			uczestnicy.add(uczestnik);
		}

		while(koniecGry() == false) {
			int idx = 0;
			kordy.clear();
			for(Kosmolot temp : uczestnicy) {
				poz_x = (temp.pozycja_x + temp.predkosc_x) % torusX;	//Kosmoloty teleportuja sie na przeciwny
				poz_y = (temp.pozycja_y + temp.predkosc_y) % torusY;	//bok po przekroczeniu granic torusow
				kord = poz_x + " " + poz_y;
				if(kordy.contains(kord)) {
					uczestnicy.remove(temp);
					uczestnicy.remove(kordy.indexOf(kord));
				}
				else {
					temp.pozycja_x = poz_x;
					temp.pozycja_y = poz_y;
					temp.odleglosc += odleglosc(poz_x, poz_y);
				}
				
			}
			czas += 1;
		}
	}
}
