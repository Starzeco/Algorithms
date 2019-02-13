
public class Main {

	public static void main(String[] args) {
		DrzewoBR br=new DrzewoBR();
		
	/*	br.Insert("aaa", 1);
		br.Insert("aaa", 3);
		br.Insert("aaa", 4);
		br.Insert("aaa", 2);
		br.Insert("baa", 1);
		br.Insert("bba", 3);
		br.Insert("aba", 1);
		
		br.PrintInOrder(br.getRoot());
		br.LevelOrder();  */
		
		br.czytaj();
		br.PrintInOrder(br.getRoot());
		br.LevelOrder();
		//br.delete(br.getRoot(),"odwiedziny");
		/*System.out.println("");
		br.Kolory2();*/
		//br.deleteKey("nawet");
		br.usun("nawet");
		br.LevelOrder();
	}

}
