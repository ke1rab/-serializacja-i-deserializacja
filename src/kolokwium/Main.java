package kolokwium;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String[] imiona = {"Karol", "Jakub", "Michal", "Krystian", "Bartosz"};
		String[] nazwiska = {"Kowalski", "Nowak", "Nowakowski", "Kowalewski", "Kaczmarek"};
		
		ArrayList<Uzytkownik> uzytkownicy = new ArrayList<Uzytkownik>();
		
		/*for(int i = 0; i < imiona.length; ++i) {
			for(int j = 0; j < nazwiska.length; ++j) {
				Uzytkownik nowy = new Uzytkownik(imiona[i], nazwiska[j], "123@gmai.com", 45);
				uzytkownicy.add(nowy);
			}
		}*/
		
		BufferedReader cn = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				System.out.println("Wybierz operacje:\n1. Dodaj uzytkownika\n2. Przerwij program");
				int input = Integer.valueOf(cn.readLine());
				
				if(input == 1) {
					Uzytkownik nowy = new Uzytkownik();
					System.out.println("Podaj imie uzytkownika:");
					nowy.setImie(cn.readLine().trim());
					System.out.println("Podaj nazwisko uzytkownika:");
					nowy.setNazwisko(cn.readLine().trim());
					System.out.println("Podaj email uzytkownika:");
					nowy.setAdresEmail(cn.readLine().trim());
					System.out.println("Podaj wiek uzytkownika:");
					nowy.setWiek(Integer.valueOf(cn.readLine()));
					
					uzytkownicy.add(nowy);
				} else if(input == 2)
					break;
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		BinarySerializer bs = new BinarySerializer();
		List<Uzytkownik> deserialized = null;
		
		try {
			bs.serialize(uzytkownicy, "uzytkownicy.bin");
			
			deserialized = bs.deserialize("uzytkownicy.bin");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(deserialized != null) {
			for(Uzytkownik u : deserialized) {
				System.out.println(u.getImie() + " " + u.getNazwisko());
			}
		}
	}
}
