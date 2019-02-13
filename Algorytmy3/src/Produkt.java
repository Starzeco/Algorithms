import java.util.Scanner;


public class Produkt{
private String nazwaT;
private int liczbaSzt;
private int cena;

public Produkt (String nazwaT,int liczbaSzt,int cena) {
	this.cena=cena;
	this.nazwaT=nazwaT;
	this.liczbaSzt=liczbaSzt;
}
public String getNazwaT() {
	return nazwaT;
}
public void setNazwaT(String nazwaT) {
	this.nazwaT = nazwaT;
}
public int getLiczbaSzt() {
	return liczbaSzt;
}
public void setLiczbaSzt(int liczbaSzt) {
	this.liczbaSzt = liczbaSzt;
}
public int getCena() {
	return cena;
}
public void setCena(int cena) {
	this.cena = cena;
}
public String toString() {
	return "Nazwa produktu to:"+" "+ nazwaT+ " "+ "Cena sztuki to:" +" "+cena+"Liczba sztuk to:"+" "+liczbaSzt;
}

/*public void Utworz() {
	Scanner sc=new Scanner(System.in);
	while(!k.isFull()) {
	
	String y=sc.nextLine();
	int l=Integer.parseInt(sc.nextLine());
	int c=Integer.parseInt(sc.nextLine());
	Produkt h=new Produkt(y,l,c);
	k.insert(h);
	
	}
	k.wyswietl();
}*/


}
