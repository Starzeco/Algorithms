import java.util.Scanner;

public class Klient {
private String nazwisko;



private Kolejka<Produkt>k=new Kolejka<Produkt>();

public Kolejka<Produkt> getKolejkaP(){
	return k;
}

public Klient(String nazwisko) {
	this.nazwisko=nazwisko;
}
public String getNazwisko() {
	return nazwisko;
}
public void setNazwisko(String nazwisko) {
	this.nazwisko = nazwisko;
}
public String toString() {
	return nazwisko;
}
public void Wypelnij() {
	Scanner sc=new Scanner(System.in);
	while(!k.isFull()) {
	System.out.println("Podaj nazw� produktu");
	String y=sc.nextLine();
	System.out.println("Podaj cen� produktu");
	int l=Integer.parseInt(sc.nextLine());
	System.out.println("Podaj ilo�� produkt�w");
	int c=Integer.parseInt(sc.nextLine());
	Produkt h=new Produkt(y,l,c);
	k.insert(h);
	
	}
	//k.wyswietl();     OPCJONALNE
	System.out.println("Lista pe�na");
}
public int Zlicz() {
	if(k.getHead()!=null) {
		int cena=0;
		 //actElement=k.getHead();
		 for(int i=0;i<k.getSize();i++) {
			Produkt o=k.findeNode(i).getValue();
			cena=o.getCena()*o.getLiczbaSzt()+cena;
			
		 }
		 return cena;
		//Produkt o=k.getHead().getValue();
		
	/*	while() {	// z�y warunek 
			cena=o.getCena()*o.getLiczbaSzt()+cena;
			o=
		}*/
	}
	else {return 0;}
}


}
