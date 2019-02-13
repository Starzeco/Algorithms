import java.io.*;
import java.util.Scanner;




public class Main2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954019899142262737L;
	static Student st11 = null;
	static int ls1;

	public static void main(String[] args) throws Exception {
	
		
		Scanner sc=new Scanner(System.in);
		int liczbaOb=Integer.parseInt(sc.nextLine());
		Student[]tab=new Student[liczbaOb];
		Iter it=new Iter(tab);
		for(int i=1;i<=liczbaOb;i++) {
			
		String nazw=sc.nextLine();
		String im=sc.nextLine();
		long alb=Long.parseLong(sc.nextLine());
		int r=Integer.parseInt(sc.nextLine());
		double sr=Double.parseDouble(sc.nextLine());
		Student st=new Student(nazw,im,alb,r,sr);
		tab[i-1]=st;
		}
		for(int i=0;i<=50;i++) {
		System.out.print("-");}
		System.out.println("");
		System.out.printf("I%-10s I%-10s I%8s I%5s I%7s I","Nazwisko","imie","album","rok","srednia");
		System.out.println("");
		for(int i=0;i<=50;i++) {
			System.out.print("-");}
			System.out.println("");
		while(it.hastNext()) {
			it.next().wyswietl();
			System.out.println("");
		}
		for(int i=0;i<=50;i++) {
			System.out.print("-");}
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Studenci.ser"))) {
			os.writeObject(liczbaOb);
			it=new Iter(tab);
			while(it.hastNext())  {
				os.writeObject(it.next());
			}
		
		}catch(Exception ex) {
			System.out.println("");
			System.out.println("Coœ siê popsu³o");
		}
		try(ObjectInputStream o = new ObjectInputStream(new FileInputStream("Studenci.ser"))) {
			int ls=(Integer)o.readObject();
			ls1=ls;
			System.out.println("");
			for(int i=1;i<=ls1;i++) {
				Object k=o.readObject();
				st11=(Student)k;
				System.out.println(st11);
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			
			
		}
	}
		
}
