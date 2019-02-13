import java.util.*;


public class Graf {

	private LinkedList<Wierzcholek> lista[];
	private int counter=-1;
	private ArrayList<Integer> pom;
	ArrayList<Integer> d=new ArrayList<Integer>();
	ArrayList<Integer> p=new ArrayList<Integer>();
	
	//private LinkedList<Integer> adj[];// Niepewne
	
	private String droga;
	public LinkedList<Wierzcholek>[] getLista() {
		return lista;
	}

	public void setLista(LinkedList<Wierzcholek>[] lista) {
		this.lista = lista;
	}


	public class Wierzcholek{
		private int numer;
		private int droga;
		
		
		public int getNumer() {
			return numer;
		}
		public void setNumer(int numer) {
			this.numer = numer;
		}
		public int getDroga() {
			return droga;
		}
		public void setDroga(int droga) {
			this.droga = droga;
		}
		public Wierzcholek(int numer,int droga) {
			this.numer=numer;
			this.droga=droga;
			
		}
		public String toString() {
			return Integer.toString(numer);
		}
		
		
	}
	
	
	public Graf(int rozmiar) {
		lista=new LinkedList[rozmiar];
		for(int i=0;i<lista.length;i++) {
			lista[i]=new LinkedList<Wierzcholek>();
			lista[i].add(0,new Wierzcholek(i,0));
		}
		//d=new ArrayList<Integer>(rozmiar);
		//p=new ArrayList<Integer>(rozmiar);
	}
	
	public void addWierzcholek(int doKtoregoWierzcholka, int numerDodawanegoWierzcholka,int droga) {
		lista[doKtoregoWierzcholka].add(0,new Wierzcholek(numerDodawanegoWierzcholka,droga));
		
	}
	
	public void Wypisz(int numer) {
		pom=new ArrayList<Integer>();
		System.out.println("Z"+" "+numer+" "+"Mo¿na przejœæ do: ");
		Wypisz2(numer);
		counter=-1;
		
		
	}
	
	private void Wypisz2(int numer) {
		if(counter==-1) {
			counter=numer;
			pom.add(numer);
		}
		if(lista[numer].isEmpty()) {
			return;
		}else {
			for(int i=0;i<lista[numer].size();i++) {
					if(!pom.contains(lista[numer].get(i).getNumer())) {
						pom.add(lista[numer].get(i).getNumer());
						System.out.print("Miasta "+lista[numer].get(i).getNumer()+"/");	
						Wypisz2(lista[numer].get(i).getNumer());
						
					}	
				}	
		}	
	}
	
	public void path(int numerWierzcholka) {
		ArrayList<Wierzcholek> S=new ArrayList<Wierzcholek>();
		ArrayList<Wierzcholek> Q=new ArrayList<Wierzcholek>();
		for(int i=0;i<lista.length;i++) {
			Q.add(lista[i].getLast());
		}
		
		//System.out.println(d.size());
		
		for(int j=0;j<lista.length;j++) {
			d.add(j,Integer.MAX_VALUE);
			
			
		}
		
		d.set(numerWierzcholka, 0);
		for(int k=0;k<lista.length;k++) {
			p.add(k,-1);
		}
		
		while(!Q.isEmpty()) {
			int index=0;
			int temp=Integer.MAX_VALUE;
			for(int ii=0;ii<d.size();ii++) {
				
				if(d.get(ii)<temp) {  // Nigdy tu nie wchodzi 
					for(int tr=0;tr<Q.size();tr++) {
						if(Q.get(tr).getNumer()==ii) {
							temp=d.get(ii);
							index=ii;
							
						}
						
					}
					
					
					
					
					
				}
			} // Znaleziona najkrotsza droga z d
			// Index to wierzcholek tego grafu  CZYLI NUMER JAKI MA WIERZCHOLEK GRAFU 
			//System.out.println("Tu jestem");
			
			for(int yt=0;yt<Q.size();yt++) {
				if(Q.get(yt).getNumer()==index) {
					S.add(Q.get(yt));
					Q.remove(Q.get(yt));
				}
			}
			
			
			
			
			// TERAZ Z GRAFU TRZEBA WZIac WEZEL Z DROGA TEMP 
			for(int y=0;y<lista[index].size();y++) {
				for(int rt=0;rt<Q.size();rt++) {
					if(Q.get(rt).getNumer()==lista[index].get(y).getNumer()) {
						if(d.get(lista[index].get(y).getNumer())>temp+lista[index].get(y).getDroga()) {
							d.set(lista[index].get(y).getNumer(), temp+lista[index].get(y).getDroga());
							p.set(lista[index].get(y).getNumer(), index);
						}
					}
					else {
						
					}
				}
				
				
			}
			
			
		}
		//System.out.println(d);
		//System.out.println(p);
		
		
	}
	public void odczytanie(int numerWierzcholkaPocz,int numerWierzcholkaKon) {
		path(numerWierzcholkaPocz);
		int droga=d.get(numerWierzcholkaKon);
		int numerek=p.get(numerWierzcholkaKon);
		if(droga==Integer.MAX_VALUE) {
			System.out.println("Nie ma po³¹czenia");
			return;
		}
		if(numerWierzcholkaPocz==numerWierzcholkaKon) {
			System.out.println("Droga to 0, to ten sam wierzcho³ek");
		}
		else {
			System.out.print("Droga jest przez "+numerWierzcholkaKon);
			while(numerek!=numerWierzcholkaPocz) {
				
				System.out.print("<==="+numerek);				 
				numerek=p.get(numerek);
			}
			System.out.print("<==="+numerWierzcholkaPocz);
			System.out.println(" Droga wynosi "+droga);
		}
		
		
		
	}
	
	public void Lista() {
		for(int i=0;i<lista.length;i++) {
			System.out.print("W "+i+" jest:");
			for(int j=0;j<lista[i].size();j++) {
				
				if(lista[i].get(j).getNumer()!=i) {
					
					System.out.print(lista[i].get(j)+"/");
				}
			}
			System.out.println("");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		Graf graf=new Graf(5);
		
		
		/*graf.addWierzcholek(1, 3, 10);
		graf.addWierzcholek(1, 4, 7);
		//graf.addWierzcholek(1, 0, 10);
		graf.addWierzcholek(3, 2, 4);
		graf.addWierzcholek(3, 5, 7);
		graf.addWierzcholek(3, 1, 6);
		graf.addWierzcholek(3,4,11);
		//graf.addWierzcholek(4, 0, 10);
		graf.addWierzcholek(4, 6, 12);
		graf.addWierzcholek(6, 1, 15);  
		graf.addWierzcholek(6, 3, 12);  
		graf.addWierzcholek(6, 0, 1);
		
		//graf.Wypisz(3);
		//Wierzcholek p=new Wierzcholek(1,0);
		
		graf.Wypisz(1);
		System.out.println("");
		graf.odczytanie(1,0);
		
		//graf.BFS(2); */
		graf.addWierzcholek(0,1,10);
		graf.addWierzcholek(0,3,30);
		graf.addWierzcholek(0,4,100);
		graf.addWierzcholek(1,2,50);
		graf.addWierzcholek(2,4,10);
		graf.addWierzcholek(3,2,20);
		graf.addWierzcholek(3,4,60);
		
		/*graf.Wypisz(0);
		System.out.println("");
		graf.odczytanie(0,1);
		graf.odczytanie(0,2);
		graf.odczytanie(0,3);
		graf.odczytanie(0,4); */
		
		graf.Lista();
		graf.Wypisz(0);
		
		
	}

}
