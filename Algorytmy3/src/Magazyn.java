import java.util.Scanner;
public class Magazyn {
	private Kolejka<Klient>k2=new Kolejka<Klient>();
	private String nazwa;
	private Firma f=new Firma();
	public Magazyn(String nazwa) {
		this.nazwa=nazwa;
	}
	
	public void Wypelnij2() {
		Scanner sc2=new Scanner(System.in);
		System.out.println("Podaj liczbê klientów");
		int p=Integer.parseInt(sc2.nextLine());
		k2.setMaxsize(p);
		while(!k2.isFull()) {
			System.out.println("Podaj nazwisko");
			String h=sc2.nextLine();
			Klient k=new Klient(h);
			k2.insert(k);
			System.out.println("Podaj liczbê produktów");
			Kolejka<Produkt> k5=k.getKolejkaP();
			int s=Integer.parseInt(sc2.nextLine());
			k5.setMaxsize(s);
			//k2.wyswietl();
			k.Wypelnij();
			
		}
		
		
		
	}
	public void WyswietlProdukty(int index) {
		Klient e=k2.findeNode(index).getValue();  
		
		Kolejka<Produkt> t=e.getKolejkaP();
		//Kolejka<Produkt> k0=k2.getNode(nazwa).getValue().getKolejkaP();
		t.wyswietl();
	}
	
	public void Zrealizuj() {
		if(k2.getHead()==null) {
			
		}
		if(k2.getHead()!=null) {
			
			Klient klient1=k2.getHead().getValue();
			Kolejka<Produkt> k3=klient1.getKolejkaP(); //chyba nie potrzebne
			int o=klient1.Zlicz();
			System.out.println("Zlecenie zrealizowane:"+klient1.getNazwisko()+","+"Kwota do zap³aty:"+" "+o);
			k2.remove();
		}
	}
	public int Zlicz() {
		if(k2.getHead()!=null) {
			int suma=0;
			for(int i=0;i<k2.getSize();i++) {
				Klient o=k2.findeNode(i).getValue();
				suma=suma+o.Zlicz();
			}
			return suma;
		}
		else {return -1;}
	}
	
	public void Menu() {
		System.out.println("Menu");
		System.out.println("");
		System.out.println("1.Wype³nij listê");
		System.out.println("2.Zrealizuj zamówienie");
		System.out.println("3.Wyswietl kolejke klientow");
	//	System.out.println("4.Wyœwietl listê produtktów klienta");
		System.out.println("4.Utwórz listê Magazynów");
		System.out.println("5.Zrealizuj Magazyn");
		while(true) {
			Scanner sc4=new Scanner(System.in);
			int d=Integer.parseInt(sc4.nextLine()); //int d=sc4.nextInt();
			switch(d) {
			case 1:
				Wypelnij2();
				break;
			case 2:
				Zrealizuj();
				break;
			case 3:
				k2.wyswietl();
				break;
			/*case 4:
				System.out.println("Podaj numer");
				
				WyswietlProdukty(Integer.parseInt(sc4.nextLine()));
				break;*/
			case 4:
				f.Wypelnij3();
				break;
			case 5:
				int sum=0;
				Kolejka<Magazyn> k5=f.getK3();
				int p=k5.getMaxsize();
				for(int i=0;i<=p;i++){
				
				sum=sum+f.ZrealizujMagazyn();
				}
				sum=sum+2;
				System.out.println(sum);
				//System.out.println("To jest max"+p);
				break; 
			}
		}
		
		
		
		
		
	}
	
	
	
}
