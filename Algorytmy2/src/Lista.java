import java.util.Random;
import java.util.Scanner;

public class Lista {
private Element head=null;
public Lista() {};
int tab1[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
int tab2[]= {0,1,2,3};
int g=tab1.length;
int h=tab2.length;
Random generator = new Random();



public void Utworz() {
	head=null;
	while(true) {
		Karta u=new Karta(4,5);
		u.setWartosc(generator.nextInt(g));
		u.setKolor(generator.nextInt(h));
		if(u.getWartosc()==0) {
			//System.out.println("Koniec");
			break;
		}
		
		Element e=new Element(u);
		
		if(head==null) {
			head=e;
			//System.out.println("Jestem przy head==null");
		}
		
		if(head!=null) {
			//System.out.println("A teraz tu");
			Element actElement=head;
			int najwieksza=Najwieksza();
			int najwiekszyK=Integer.MIN_VALUE;
			int indexNajK=0;
			
			Element actElement1=head; //test ( Zmieniam wszystko dla while najwieksza wartosc
			Element actElement2=head; // to samo tylko dla koloru
			
			/*while(actElement1!=null) {
				System.out.println("Najwieksza wartosc");
				if(najwieksza<actElement1.getK().getWartosc()) {
					najwieksza=actElement1.getK().getWartosc();
					int indexNajW=indexOf(actElement1.getK());
				}
			actElement1=actElement1.getNext();	
			}*/
			
			
			while(actElement!=null) {
				
				//System.out.println("Wszedlem tutaj?");
				if(e.getK().getWartosc()<actElement.getK().getWartosc()) {
					//System.out.println("?");
					int index=indexOf(actElement.getK());
					add(index,e.getK());
					break;
				}
				if(e.getK().getWartosc()>najwieksza) {
					//System.out.println("!");
					add(e.getK());
					break;
				}
				if(e.getK().getWartosc()==actElement.getK().getWartosc()) {
					//System.out.println(">");
					while(actElement2!=null) {
						//System.out.println("Najmniejsza");
						if(najwiekszyK<=actElement2.getK().getKolor() && e.getK().getWartosc()==actElement2.getK().getWartosc() ) {
							najwiekszyK=actElement2.getK().getKolor();
							indexNajK=indexOf(actElement2.getK());
							
						}
						actElement2=actElement2.getNext();
					}
					
					if(e.getK().getWartosc()==actElement.getK().getWartosc() && e.getK().getKolor()<actElement.getK().getKolor()) { //Tu chyba nie potrzebny pierwszy warunek
						int index2=indexOf(actElement.getK());
						add(index2,e.getK());
						break;
					}
					if(e.getK().getWartosc()==actElement.getK().getWartosc() && e.getK().getKolor()>najwiekszyK) {
					//	int index3=indexOf(actElement.getK());   //Nullpointer  // Jeœli jest kolejny dodaj na getNext jest nie ma na koniec !!!
						/*if(actElement.getNext()!=null) {
							
							add(indexOf(actElement.getNext().getK()),e.getK());
						}
						if(actElement.getNext()==null) {
							add(e.getK());
						}
						//add(index3,e.getK());
						break;*/
						
						if(getElement(indexNajK).getNext()!=null) { // TO NIE JEST INDEKX ,indexNajK trzeba dac edit. juz chyba dobrze 
							add(indexOf(getElement(indexNajK).getNext().getK()),e.getK());
						}
						if(getElement(indexNajK).getNext()==null) {
							add(e.getK());
						}
						break;
						
						
					}
					if(e.getK().getWartosc()==actElement.getK().getWartosc() && e.getK().getKolor()==actElement.getK().getKolor()) {
						if(actElement.getNext()==null) {
							add(e.getK());
						}
						if(actElement.getNext()!=null) {
							add(indexOf(actElement.getNext().getK()),e.getK());
						}
						
						
						//int index4=indexOf(actElement.getK());
						//add(index4,e.getK());
						break;
					}
					
				}
			
					
					
					actElement=actElement.getNext();
			}
		}
		
	}
}



public boolean isEmpty(){
return head==null;}

public int size() {
	int pos=0;
	Element actElement=head;
	while(actElement!=null) {
		pos++;
		actElement=actElement.getNext();
	}
	System.out.println(pos);
	return pos;
}


public Element getElement(int index) {
	Element actElement=head;
	while(index>0 && actElement!=null) {
		index--;
		actElement=actElement.getNext();
		
	}
	return actElement;
}
public void add(Karta k) {
	Element p=new Element(k);
	if(head==null) {
		head=p;
	}
	if(head!=null) {
		Element actElement=head;
		while(actElement.getNext()!=null) {
			actElement=actElement.getNext();		
		}
		
		actElement.setNext(p);
	}
}
public void add(int index,Karta k) {
	Element e=new Element(k);
	if(index==0) {
		head=e;
	}
	else{Element e2=getElement(index-1);
	if(e2==null) {
		System.out.println("b³¹d");
	}
	e.setNext(e2.getNext());
	e2.setNext(e);}
}
public int indexOf(Karta k) {
	int pos=0;
	Element actElem=head;
	while(actElem!=null){
		
		if(actElem.getK()==k) {
			return pos;}
		pos++;
		actElem=actElem.getNext();
		}
	System.out.println("hej");
	return -1;}

public boolean contains(Karta k) {
	return indexOf(k)>=0;
}

public void remove(Karta k) {
	if(head==null) {System.out.println("lista pusat");
	
	}
	if(head.getK().equals(k)) {
		head=head.getNext();
	}
	else{Element actElem=head;
	while(!actElem.getNext().getK().equals(k) && actElem!=null){
		actElem=actElem.getNext();
	}
	
	
	if(actElem.getNext()==null) {
		
	}
	actElem.setNext(actElem.getNext().getNext());
	}
	}
public void remove(int index) {
	if(head==null) {
		
	}
	if(index==0) {
		Karta retValue=head.getK();
		head=head.getNext();
	}
	Element actElem=getElement(index-1);
	if(actElem==null || actElem.getNext()==null) {
		
	}
	actElem.setNext(actElem.getNext().getNext());
}

public void wyswietl() {
	if(head==null) {
		System.out.println("Pierwszy byl zerem");
	}
	//System.out.println("Czemu nie dzia³am");
	Element actElem=head;
	while(actElem!=null) {
	System.out.println(actElem);
	//System.out.println("Skoro powinienem");
	actElem=actElem.getNext();
	
}
}
public int Najwieksza() {
	
	int najwieksza=Integer.MIN_VALUE;
	
		
			Element actElement=head;
		while(actElement!=null) {
				if(najwieksza<actElement.getK().getWartosc()) {
					najwieksza=actElement.getK().getWartosc();
				}
				//System.out.println("No i co");
				actElement=actElement.getNext();
			}
		
		
	return najwieksza;
		
}
public void WyswietlOWartosci(int o) {
	if(head==null) {
		System.out.println("Pusta kolejeczka");
	}
	if(head!=null) {
		Element actElement=head;
		while(actElement!=null) {
			if(actElement.getK().getWartosc()==o) {
				System.out.println(actElement);
			}
			actElement=actElement.getNext();
		}
	}
}
public void WyswietlOKolorze(int y) {
	if(head==null) {
		System.out.println("Pusta kolejeczka");
	}
	if(head!=null) {
		Element actElement=head;
		while(actElement!=null) {
			if(actElement.getK().getKolor()==y) {
				System.out.println(actElement);
			}
			actElement=actElement.getNext();
		}
	}
}
public void UsunKolor(int r) {
	if(head==null) {
		System.out.println("Pusta lista");
	}
	if(head!=null) {
		Element elem=head;
		while(elem!=null) {
			if(elem.getK().getKolor()==r) {
				remove(elem.getK());
			}
			elem=elem.getNext();
		}
	}
}
public void Menu() {
	System.out.println("Menu");
	System.out.println("");
	System.out.println("1.Utworz liste");
	System.out.println("2.Wyswietl");
	System.out.println("3.WyswietlKartyOWartosci");
	System.out.println("4.WyswietlLiczbeKArt");
	System.out.println("5.WyswietlKartyOKolorze");
	System.out.println("6.Usuñ kolor");
	System.out.println("7.Usuñ duplikaty");
	System.out.println("8.Dodaj 3 duplikaty");
	while(true) {
		Scanner sc=new Scanner(System.in);
		int d=sc.nextInt();
		switch(d) {
		case 1:
			Utworz();
			break;
		case 2:
			wyswietl();
			break;
		case 3:
			int y=sc.nextInt();
			WyswietlOWartosci(y);
			break;
		case 4 :
			size();
			break;
		case 5:
			WyswietlOKolorze(sc.nextInt());
			
			break;
		case 6:
			UsunKolor(sc.nextInt());
			break;
		case 7:
			UsunDuplikta();
			break;
		case 8:
			Dodaj3Duplikaty();
			break;
		}
		
	}
}
public void UsunDuplikta() {
	if(head!=null) {
		Element elem=head;
		while(elem!=null) {
			if(elem.getNext()!=null) {
				if(elem.getK().getKolor()==elem.getNext().getK().getKolor() && elem.getK().getWartosc()==elem.getNext().getK().getWartosc()) {
					remove(elem.getK());
			}
			}
			elem=elem.getNext();
		}
	}
}
public void Dodaj3Duplikaty() {
	for(int i=0;i<3;i++) {
		Karta u=new Karta(13,3);
		add(u);
	}
}

}
