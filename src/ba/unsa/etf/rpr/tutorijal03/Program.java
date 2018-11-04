package ba.unsa.etf.rpr.tutorijal03;

import java.util.Scanner;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		Imenik imeniik = new Imenik();
		int meni;
		do {
			System.out.println("Izaberite opciju: ");
			System.out.println("1 - Dodaj kontakt");
			System.out.println("2 - Nadji broj osobe");
			System.out.println("3 - Pregled svih brojeva za osobe sa datim pocetnim slovom");
			System.out.println("4 - Pregled svih osoba iz grada");
			System.out.println("5 - Pregled svih brojeva iz grada");
			System.out.println("6 - Izlaz");
			Scanner ulaz = new Scanner(System.in);
			meni = ulaz.nextInt();
			switch (meni) {
				case 1:
					System.out.print("Unesite ime: ");
					ulaz.nextLine();
					String ime = ulaz.nextLine();
					System.out.println("1 -  Fiksni broj");
					System.out.println("2 -  Mobilni broj");
					System.out.println("3 -  Medjunarodni broj");
					int meni2 = ulaz.nextInt();
					ulaz.nextLine();
					String broj;
					switch (meni2) {
						case 1:
							System.out.print("Unesite grad (TRAVNIK(30), ORASJE(31), ZENICA(32), SARAJEVO(33), LIVNO(34), TUZLA(35), MOSTAR(36), BIHAC(037), GORAZDE(38), SIROKIBRIJEG(39), BRCKO(49)): ");
							String pozBroj = ulaz.nextLine();
							System.out.print("Unesite broj: ");
							broj = ulaz.nextLine();
							imeniik.dodaj(ime, new FiksniBroj(FiksniBroj.Grad.valueOf(pozBroj), broj));
							break;
						case 2:
							System.out.print("Unesite pozivni broj: ");
							int pozBrojMob = ulaz.nextInt();
							ulaz.nextLine();
							System.out.print("Unesite broj: ");
							broj = ulaz.nextLine();
							imeniik.dodaj(ime, new MobilniBroj(pozBrojMob, broj));
							break;
						case 3:
							System.out.print("Unesite pozivni broj: ");
							String pozBrojDrzava = ulaz.nextLine();
							System.out.print("Unesite broj: ");
							broj = ulaz.nextLine();
							imeniik.dodaj(ime, new MedunarodniBroj(pozBrojDrzava, broj));
							break;
					}
					break;
				case 2:
					System.out.print("Unesite ime osobe: ");
					ulaz.nextLine();
					String imeOsobe = ulaz.nextLine();
					try {
						System.out.println("Broj: " + imeniik.dajBroj(imeOsobe));
					} catch (Exception greska) {
						System.out.println(greska.getMessage());
					}
					break;
				case 3:
					System.out.print("Unesite pocetno slovo: ");
					ulaz.nextLine();
					char pocSlovo = ulaz.nextLine().charAt(0);
					try {
						System.out.println(imeniik.naSlovo(pocSlovo));
					} catch (Exception greska) {
						System.out.println(greska.getMessage());
					}
					break;
				case 4:
					System.out.print("Unesite grad (TRAVNIK(30), ORASJE(31), ZENICA(32), SARAJEVO(33), LIVNO(34), TUZLA(35), MOSTAR(36), BIHAC(037), GORAZDE(38), SIROKIBRIJEG(39), BRCKO(49)): ");
					ulaz.nextLine();
					String grad = ulaz.nextLine();
					Set<String> rezultat = imeniik.izGrada(FiksniBroj.Grad.valueOf(grad));
					int i = 1;
					for(String osoba: rezultat) {
						System.out.println(i + ". " + osoba);
						i++;
					}
					if (i==1)
						System.out.println("Nema registrovanih osoba u datom gradu");
					break;
				case 5:
					System.out.print("Unesite grad (TRAVNIK(30), ORASJE(31), ZENICA(32), SARAJEVO(33), LIVNO(34), TUZLA(35), MOSTAR(36), BIHAC(037), GORAZDE(38), SIROKIBRIJEG(39), BRCKO(49)): ");
					ulaz.nextLine();
					String grad2 = ulaz.nextLine();
					Set<TelefonskiBroj> rezultat2 = imeniik.izGradaBrojevi(FiksniBroj.Grad.valueOf(grad2));
					int j = 1;
					for(TelefonskiBroj osoba2: rezultat2) {
						System.out.println(j + ". " + osoba2.ispisi());
						j++;
					}
					if (j==1)
						System.out.println("Nema registrovanih osoba u datom gradu");
					break;
			}
		} while (meni != 6);
		System.out.println("Kraj");
	}
}