
public class Element {
private Karta k;
private Element next;

public Element(Karta k) {
	this.k=k;
}


public Karta getK() {
	return k;
}

public void setK(Karta k) {
	this.k = k;
}


public Element getNext() {
	return next;
}
public void setNext(Element next) {
	this.next = next;
}

@Override
public String toString() {
	return "Wartosc to="+k.getWartosc()+" "+"Kolor to="+k.getKolor();
}

}
