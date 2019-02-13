import java.util.Random;

public class Karta {
private int wartosc;
private int kolor;

Random generator = new Random();

/*public Karta(int tab1[],int tab2[]) {
	this.wartosc=generator.nextInt(tab1.length);
	this.kolor=generator.nextInt(tab2.length);
}
*/
public Karta() {
	
}
public Karta(int i,int k) {
	wartosc=i;
	
	kolor=k;
}
public int getWartosc() {
	return wartosc;
}

public void setWartosc(int wartosc) {
	this.wartosc = wartosc;
}

public int getKolor() {
	return kolor;
}
/*public boolean porownaj() {
	if(getWartosc()==getWartosc() && getKolor==getKolor) {
		return true;
	}
	return false;
}*/
public void setKolor(int kolor) {
	this.kolor = kolor;
}
public String toString() {
	return "Wartoœæ to="+wartosc+" "+"Kolor to="+kolor+" ";
}



}
