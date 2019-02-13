import java.util.Scanner;
import java.io.*;




public class BazaDanych implements Serializable  {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
Lista<Osoba> k=new Lista<Osoba>();

public void Menu() {
	System.out.println("Menu");
	System.out.println("");
	System.out.println("1.Utworz now¹ liste");
	System.out.println("2.Wyswietl liste");
	System.out.println("3.Wyswietl Osobe o nazwisku");
	System.out.println("4.Rozmiar listy");
	System.out.println("5.Dodaj now¹ osobe");
	System.out.println("6.Usuñ osobe o nazwisku");
	System.out.println("7.Aktualizuj osobe o peselu");
	System.out.println("8.Zapisz osoby");
	System.out.println("9.Odczytaj osoby");
	System.out.println("10.Ile osób ma niedowage?");
	System.out.println("11.Ile osób ma nadwagê?");
	while(true) {
		Scanner sc=new Scanner(System.in);
		int d=Integer.parseInt(sc.nextLine());
		switch(d) {
		case 1:
			Utworz();
			break;
		case 2:
			k.wyswietl();
			break;
		case 3:
			System.out.println("Podaj nazwisko");
			String y=sc.nextLine();
			WyswietlKonkretnaOsobe(y);
			break;
		case 4 :
			System.out.println(k.size());
			break;
		case 5:
			DodajOsobe();
			
			break;
		case 6:
			System.out.println("Podaj nazwisko osoby do usuniecia");
			UsunOsobe(sc.nextLine());
			break;
		case 7:
			System.out.println("Podaj pesel osoby do aktualizacji");
			Aktualizuj(Integer.parseInt(sc.nextLine()));
			break;
		case 8:
			Zapisz();
			break; 
		case 9:
			Odczytaj();
			break;
		case 10:
			System.out.println(IleOsobManiedowage());
			break;
		case 11:
			System.out.println(IleOsobMaNadwage());
			break;
		}
		
	}
}



public void Utworz() {
	k.setHead(null);
	System.out.println("Podaj liczbê osób");
	Scanner sc=new Scanner(System.in);
	int liczb=Integer.parseInt(sc.nextLine());
	int i=0;
	//Element<Osoba> e=k.getHead();
	while(i<liczb) {
		System.out.println("Podaj pesel");
		int pesel=Integer.parseInt(sc.nextLine());
		System.out.println("Podaj nazwisko");
		String nazwisko=sc.nextLine();
		System.out.println("Podaj imie");
		String imie=sc.nextLine();
		System.out.println("Podaj wage");
		double waga=Double.parseDouble(sc.nextLine());
		System.out.println("Podaj wzrost");
		double wzrost=Double.parseDouble(sc.nextLine());
		System.out.println("Podaj date urodzenia");
		String data=sc.nextLine();
		Osoba p=new Osoba(pesel,nazwisko,imie,waga,wzrost,data);
		Element<Osoba> elem=new Element<Osoba>(p);
		Element<Osoba> e=k.getHead();
		if(!k.isEmpty()) {
			//Element<Osoba> actElem=new Element<Osoba>(p);
			
			int najwieksza=Najwieksza();
			while(e!=null) {
				if(elem.getValue().getPesel()<e.getValue().getPesel()) {
					int indexPom=k.indexOf(e.getValue());
					k.addIndex(indexPom, p);
					//k.addIndex(indexPom+1, e.getValue());
					i++;
					break;
				}
				if(elem.getValue().getPesel()>najwieksza) {
					k.addNaKoniec(p);
					i++;
					break;
					
				}
				if(elem.getValue().getPesel()==e.getValue().getPesel()) {
					System.out.println("Nie ma dwóch takich samych peseli");
					break;
				}
				
				e=e.getNext();  
			}
			
		}
		if(k.isEmpty()) {
			k.addNaKoniec(p);
			i++;
			
		}
	}

}
public int Najwieksza() {
	int najwieksza=Integer.MIN_VALUE;
	
	Element<Osoba> elem=k.getHead();
	while(elem!=null) {
		if(najwieksza<elem.getValue().getPesel()) {
			najwieksza=elem.getValue().getPesel();
		}
		elem=elem.getNext();
	}
	return najwieksza;
}
public void WyswietlKonkretnaOsobe(String nazwisko) {
	Element<Osoba> p=k.getHead();
	if(p==null) {
		System.out.println("Nie ma takiej osoby, bo lista pusta jest");
	}
	if(p!=null) {
		while(p!=null) {
			if(p.getValue().getNazwisko().equals(nazwisko)) {
				System.out.println(p.getValue());
			}
			p=p.getNext();
		}
	}
	else {
		System.out.println("Nie ma takiej osoby");
	}
}
public int IleOsobManiedowage() {
	Element<Osoba> p=k.getHead();
	int counter=0;
	if(p==null) {
		System.out.println("Lista pusta");
	}
	if(p!=null) {
		while(p!=null) {
			if(p.getValue().getBMI()<20) {
				counter++;
			}
			p=p.getNext();
		}
	}
	return counter;
}
public int IleOsobMaNadwage() {
	Element<Osoba> p=k.getHead();
	int counter=0;
	if(p==null) {
		System.out.println("Lista pusta");
	}
	if(p!=null) {
		while(p!=null) {
			if(p.getValue().getBMI()>25) {
				counter++;
			}
			p=p.getNext();
		}
	}
	return counter;
}
public void Wyswietl() {
	k.wyswietl();
}
public void DodajOsobe() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Podaj pesel nowej osoby");
	int pesel=Integer.parseInt(sc.nextLine());
	System.out.println("Podaj nazwisko nowej osoby");
	String nazwisko=sc.nextLine();
	System.out.println("Podaj imie nowej osoby");
	String imie=sc.nextLine();
	System.out.println("Podaj wage nowej osoby");
	double waga=Double.parseDouble(sc.nextLine());
	System.out.println("Podaj wzrost nowej osoby");
	double wzrost=Double.parseDouble(sc.nextLine());
	System.out.println("Podaj date urodzenia nowej osoby");
	String data=sc.nextLine();
	Osoba p=new Osoba(pesel,nazwisko,imie,waga,wzrost,data);
	
	Element<Osoba> elem=new Element<Osoba>(p);
	int size=k.size();
	int i=0;
	Element<Osoba> e=k.getHead();
	while(i<size) {   //Jakby coœ nie dzia³a³o to mo¿e tu powinno byæ <=
		
		if(!k.isEmpty()) {
		//Element<Osoba> actElem=new Element<Osoba>(p);
			
			int najwieksza=Najwieksza();
		
				if(elem.getValue().getPesel()<e.getValue().getPesel()) {
					int indexPom=k.indexOf(e.getValue());
					k.addIndex(indexPom, p);
					break;
				
				}
				if(elem.getValue().getPesel()>najwieksza) {
					k.addNaKoniec(p);
					break;
				
				
				}
				if(elem.getValue().getPesel()==e.getValue().getPesel()) {
					System.out.println("Nie ma dwóch takich samych peseli");
					break;
				}
				
		}
		i++;
		e=e.getNext();} 
			
		
	
}
public void DodajOsobe(Osoba p) {
	Element<Osoba> e=k.getHead();
	Element<Osoba> elem=new Element<Osoba>(p);
	int size=k.size();
	int i=0;
	while(i<size) {   //Jakby coœ nie dzia³a³o to mo¿e tu powinno byæ <=
		
		if(!k.isEmpty()) {
		//Element<Osoba> actElem=new Element<Osoba>(p);
			
			int najwieksza=Najwieksza();
		
				if(elem.getValue().getPesel()<e.getValue().getPesel()) {
					int indexPom=k.indexOf(e.getValue());
					k.addIndex(indexPom, p);
					break;
				
				}
				if(elem.getValue().getPesel()>najwieksza) {
					k.addNaKoniec(p);
					break;
				
				
				}
				if(elem.getValue().getPesel()==e.getValue().getPesel()) {
					System.out.println("Nie ma dwóch takich samych peseli");
					break;
				}
				
		}
		if(k.isEmpty()) { 				//Jakby coœ zle to tutaj to dodalem 
			k.addNaKoniec(p);
			break;
			
		}
		i++;
		e=e.getNext();} 
			
		
	
}
	
public void UsunOsobe(String nazwisko) {
	Element<Osoba> e=k.getHead();
	if(e==null) {
		System.out.println("Lista jest pusta, jak chcesz coœ usun¹æ");
	}
	
	if(e!=null) {
		if(e.getValue().getNazwisko().equals(nazwisko)) {
			if(e.getNext()!=null) {
				e.getNext().setPrevious(null);
				k.setHead(e.getNext());
			}
			else {
				k.setHead(null);
			}
		}
		else {
			while(e!=null && !e.getNext().getValue().getNazwisko().equals(nazwisko) ) { // Tutaj zeby nie by³o nullpointer'a jak usuwam cos czego nie ma to moze e.getNext!=null
				e=e.getNext();
			}
			if(e.getNext()==null) {
				System.out.println("Nie ma takiej osoby (w petli)");
				//tutaj chyba musze dopisac
			}
			if(e.getNext().getNext()==null) {
				e.getNext().setPrevious(null);
				e.setNext(null);
				
			}
			else {
				e.getNext().getNext().setPrevious(e);
				e.setNext(e.getNext().getNext());
			}
			 // Tutaj trzeba dorobiæ //// To muszê przemyœleæ Trzeba prev i next zmienic dobrze 
		}
	}
	else {
		System.out.println("Nie ma takiej osoby");
	}
}
public void Aktualizuj(int pesel) {
	Element<Osoba> e=k.getHead();
	if(e==null) {
		System.out.println("Lista jest pusta, jak chcesz aktualizowac");
	}
	if(e!=null) {
		while(e!=null) {
			if(e.getValue().getPesel()==pesel) {
				Scanner sc=new Scanner(System.in);
				System.out.println("Co chcesz zmienic?");
				System.out.println("1.Pesel");
				System.out.println("2.Nazwisko");
				System.out.println("3.Imie");
				System.out.println("4.Waga");
				System.out.println("5.Wzrost");
				System.out.println("6.Date urodzenia");
				int k=Integer.parseInt(sc.nextLine());
				System.out.println("Podaj now¹ wartoœæ");
				switch(k) {
				case 1:
					int nowyPesel=Integer.parseInt(sc.nextLine());
					Osoba pom=new Osoba(nowyPesel,e.getValue().getNazwisko(),e.getValue().getImie(),e.getValue().getWaga(),e.getValue().getWzrost(),e.getValue().getData());
					UsunOsobe(e.getValue().getNazwisko());
					DodajOsobe(pom); 			// Tak trzeba zrobiæ dla ka¿dego to nowe BMI bêdzie sie obliczac itd.
					break;
				case 2:
					e.getValue().setNazwisko(sc.nextLine());
					break;
				case 3:
					e.getValue().setImie(sc.nextLine());
					break;
				case 4:
					int nowaWaga=Integer.parseInt(sc.nextLine());
					Osoba pom2=new Osoba(e.getValue().getPesel(),e.getValue().getNazwisko(),e.getValue().getImie(),nowaWaga,e.getValue().getWzrost(),e.getValue().getData());
					UsunOsobe(e.getValue().getNazwisko());
					DodajOsobe(pom2);
					break;
				case 5:
					int nowyWzrost=Integer.parseInt(sc.nextLine());
					Osoba pom3=new Osoba(e.getValue().getPesel(),e.getValue().getNazwisko(),e.getValue().getImie(),e.getValue().getWaga(),nowyWzrost,e.getValue().getData());
					UsunOsobe(e.getValue().getNazwisko());
					DodajOsobe(pom3);
					break;
				case 6:
					e.getValue().setData(sc.nextLine());
					break;
					
				}
			}
			e=e.getNext();
		}
	}
	
	
}
public void Zapisz() {
	try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Osoby.ser"))) {
		Element<Osoba> e=k.getHead();
		int r=k.size();
		os.writeObject(r);
		while(e!=null) {
			Osoba pom2=e.getValue();
			os.writeObject(pom2);
			e=e.getNext();
		}
		os.close();
	}catch(IOException ex) {
		ex.printStackTrace();
	}
	
	
	
}
public void Odczytaj() {
	try(ObjectInputStream o = new ObjectInputStream(new FileInputStream("Osoby.ser"))){
		int ls=(Integer)o.readObject();
		k.setHead(null);
		for(int i=1;i<=ls;i++) {
			Osoba pom=(Osoba)o.readObject();
			//System.out.println(pom);  // Odczytuje dobrze, ale nie chce dodaæ do listy Musi chyba tworzyæ now¹ 
			//DodajOsobe(pom);
			k.addNaKoniec(pom);
			
		}
		o.close();
	}catch (Exception ex) {
		ex.printStackTrace();
		
		
	}
	
	
	
}



}


