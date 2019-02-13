import java.util.Scanner;

public class Firma {
	private Kolejka<Magazyn>k3=new Kolejka<Magazyn>();
	
	public Kolejka<Magazyn> getK3() {
		return k3;
	}



	public void setK3(Kolejka<Magazyn> k3) {
		this.k3 = k3;
	}



	public void Wypelnij3() {
		Scanner sc3=new Scanner(System.in);
		System.out.println("Podaj liczbê magazynów");
		int p=Integer.parseInt(sc3.nextLine());
		k3.setMaxsize(p);
		while(!k3.isFull()) {
			System.out.println("Podaj nazwê magazynu");
			String h=sc3.nextLine();
			Magazyn a=new Magazyn(h);
			k3.insert(a);
			a.Wypelnij2();
		}
		
		
	}
	
	
	
	public int ZrealizujMagazyn() {
		if(k3.getHead()==null) {
			return -2;
		}
		if(k3.getHead()!=null) {
			Magazyn mag=k3.getHead().getValue();
			int sumka=mag.Zlicz();
			//System.out.println(sumka);
			k3.remove();
			return sumka;
		}
		else { return -1;}
		
	}
	
	
}
