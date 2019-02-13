import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Menu {
	
	
	
	
	ArrayList<Karta> array;
	int tab1[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
	int tab2[]= {0,1,2,3};
	Random generator = new Random();
	public Menu() {
		array=new ArrayList<Karta>();
	}
	int g=tab1.length;
	int h=tab2.length;
	
	public void dodaj() {
		Karta p=new Karta(1,0);
		for(int i=0;i<3;i++) {
			array.add(0, p);
		}
	}
	public void UsunDuplikat() {
		ItArray it=new ItArray(array);
		while(it.hasNext()) {
			int e=array.indexOf(it.next1());
			Karta elem=array.get(e);
			if(e<(array.size()-1)) {
			Karta elem2=array.get(++e);
			if(elem.getWartosc()==elem2.getWartosc() && elem.getKolor()==elem2.getKolor()) {
				array.remove(e);
			}
		}
		}	
	}
	
	public void Utworz() {
		
		while(true) {
			Karta u=new Karta(4,5);
			u.setWartosc(generator.nextInt(g));
			u.setKolor(generator.nextInt(h));
			int war=u.getWartosc();
			int kol=u.getKolor();
			
			if(u.getWartosc()==0){
				
				return;
			}
			
			
			int najwieksza=Integer.MIN_VALUE;
			int najwiekszykolor=Integer.MIN_VALUE;
			int indexK=0;
			for(int i=0;i<array.size();i++) {
				
				
				if(najwieksza<array.get(i).getWartosc()) {
					najwieksza=array.get(i).getWartosc();
					int indexNajw=i;
				}
			}
			if(!array.isEmpty()) {
				for(int i=0;i<array.size();i++) {
					
					
					if(war<array.get(i).getWartosc())	{
					
					int index=i;
					array.add(index, u);
					break;
					}
				
					if(war>najwieksza) {
						array.add(u);
						break;
					}
					if(war==array.get(i).getWartosc()) {
						for(int s=0;s<array.size() ;s++) {
							
							if(najwiekszykolor<array.get(s).getKolor()&& array.get(s).getWartosc()==war) {  //PRZEANALIZOWAC
									najwiekszykolor=array.get(s).getKolor();
								indexK=i;
							}
							
							if(kol<array.get(s).getKolor()&& array.get(s).getWartosc()==war) {
								int index2=s;
								array.add(index2,u);
								break;
							}
							if(kol>najwiekszykolor) {
								int y=indexK+1;
								array.add(y,u);
								break;
							}
							if(kol==najwiekszykolor&& array.get(s).getWartosc()==war) {
								array.add(indexK,u);
								
								break;
							}
						}
					} //zobaczyc
					
					
			break;		

			}
				}
			if(array.isEmpty()) {
				array.add(u);
			}
				
			}
	}
	public void wyswietl() {
		for(Karta k:array) {
			System.out.println(k);
		}
	}
	public void wyswietlLiczbe() {
		int licznik=0;
		for(int i=0;i<array.size();i++) {
			licznik++;
		}
		System.out.println(licznik);
	}
	public void wyswietlKartyOWartosci(int p) {
		for(Karta j:array) {
			if(j.getWartosc()==p) {
				System.out.println(j);
			}
		}
	}
	public void wyswietlKartyOWartosci2(int p) {
		ItArray it=new ItArray(array);
		while(it.hasNext()) {
			Karta elem=it.next1();
			if(elem.getWartosc()==p) {
				System.out.println(elem);
			}
		}
	}
	public void wyswietlKartyOKolorze(int k) {
		for(Karta s:array) {
			if(s.getKolor()==k) {
				System.out.println(s);
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
		System.out.println("6.Usun Duplikat");
		System.out.println("7.Dodaj 3 asy kier");
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
				wyswietlKartyOWartosci2(y);
				break;
			case 4 :
				wyswietlLiczbe();
				break;
			case 5:
				
				wyswietlKartyOKolorze(sc.nextInt());
				break;
			case 6:
				UsunDuplikat();
				UsunDuplikat();
				break;
			case 7:
				dodaj();
				break;
			}
			
		}
		
	}
	
}
