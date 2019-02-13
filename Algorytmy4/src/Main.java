
public class Main {
	//(5+7)/(4-1)
	//(13*24)+(23-1)*(3+8)=554
	//3+4*(3+2)-65=-42
	public static void main(String[] args) {
		InfixtoPostfix k=new InfixtoPostfix();
		Drzewo d=new Drzewo();
		//System.out.println(k.convert("2+38*2+6"));
		//d.Utworz(k.convert("((10+2)*(2+3))/10"));
		//System.out.print(d.Obliczanie(d.getRoot()));
	/*	System.out.println(k.convert("((2+3)*2+2)%5"));
		System.out.println(k.convert("((10+2)*(2+3))/10"));
		System.out.println(k.convert("(2+2)/(2-2)"));
		System.out.println(k.przeliczanie2(k.convert("((2+3)*2+2)%5")));
		System.out.println(k.przeliczanie2(k.convert("((10+2)*(2+3))/10")));
		System.out.println(k.przeliczanie2(k.convert("(2+2)/(2-2)")));*/
		//System.out.println(k.convert("((10+2)*(2+3))/10"));
		//k.Sprawdz("kask");
		
		
		
		/*d.PrintInOrder(d.getRoot());
		System.out.println("");
		d.PrintPostOrder(d.getRoot());
		System.out.println("");
		System.out.println(d.Obliczanie(d.getRoot()));
		d.Liscie(d.getRoot());
		System.out.println(d.getCounterL());
		d.Wezly(d.getRoot());
		System.out.println(d.getCounterN());
		System.out.println(d.Wysokosc(d.getRoot()));*/
		
		//d.Menu();
		
		DrzewoBST ds=new DrzewoBST();
		ds.Utworz();
		ds.PrintPostOrder(ds.getRoot());
		
		if("aaa".compareTo("baa")==1) {
			System.out.println("aaa jest wiêksze");
			
		}
		if("aaa".compareTo("baa")==-1) {
			System.out.println("aaa jest wiêksze2");
			
		}
		
	}

}
