import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Drzewo {
private Wezel<Object> root=null;
private Stos<Wezel<Object>> stos;
private InfixtoPostfix l=new InfixtoPostfix();

private int counterL=0;
private int counterN=0;




public Wezel<Object> getRoot() {
	return root;
}
public boolean empty() {
	if(root==null) {
		return true;
	}
	else {return false;}
}
public void Utworz(String postfix) {
	stos=new Stos<Wezel<Object>>();
	char [] tab=postfix.toCharArray();
	for(int i=0;i<tab.length;i++) {
		if(tab[i]==' ') {
			i++;
			String pom="";
			if(Character.isDigit(tab[i])) {
				while(Character.isDigit(tab[i])) {
					pom=pom+Character.toString(tab[i]);
					i++;
				
				}
				if(tab[i]==' ') {
					i--;
				}
				int p=Integer.parseInt(pom);
				Wezel<Object> tem=new Wezel<Object>(p);
				stos.push(tem);
			}
			else {
				
			}
			
			//konwersja stringa do inta i pushniecie 
		}
		if(l.isOperator(tab[i])) {
			Wezel<Object> temp=new Wezel<Object>(tab[i]);
			temp.setRight(stos.peek());
			stos.pop();
			temp.setLeft(stos.peek());
			stos.pop();
			stos.push(temp);
		}
		
			
		}
		root=stos.pop();
		
	
}
public void PrintInOrder(Wezel<Object> wez) {		
	if(wez!=null) {
		System.out.print("(");
		PrintInOrder(wez.getLeft());
		//System.out.print(")");
		System.out.print(wez.getValue());
		//System.out.print("(");
		PrintInOrder(wez.getRight());
		System.out.print(")");
	}
}
public void PrintPostOrder(Wezel<Object> wez) {		// Odwrotna notacja polska
	if(wez!=null) {
		PrintPostOrder(wez.getLeft());
		PrintPostOrder(wez.getRight());
		System.out.print(wez.getValue());
	}
}
public int Obliczanie(Wezel<Object> wez) {
	if(wez!=null) {
		if(wez.getValue() instanceof Integer) {
			return Integer.parseInt(wez.getValue().toString());
		}
		int a=Obliczanie(wez.getLeft());
		int b=Obliczanie(wez.getRight());
		return Dzialania(a,b,(char)wez.getValue());
	}
	else {
		return 0;
	}
}

public int Dzialania(int a,int b,char op) {
	if(op=='+') {
		return a+b;
	}
	if(op=='-') {
		return a-b;
	}
	if(op=='*') {
		return a*b;
	}
	if(op=='/') {
		if(b==0) {
			return -1;
		}
		else {
		return a/b;
		}
	}
	if(op=='%') {
		return a%b;
	}
	else {
		return 0;
	}
}
public void Liscie(Wezel<Object> wez) {
	if(wez!=null) {
		if(wez.getLeft()==null && wez.getRight()==null) {
			this.counterL++;
		}
		Liscie(wez.getLeft());
		Liscie(wez.getRight());
		
	}
	
}
public int getCounterL() {
	return counterL;
}
public void Wezly(Wezel<Object> wez) {
	if(wez!=null) {
		this.counterN++;
		Wezly(wez.getLeft());
		Wezly(wez.getRight());
			
	}
}
public int getCounterN() {
	return counterN;
}
public int Wysokosc(Wezel<Object> wez) {
	if(wez==null) {
		return -1;
	}
	int lewy=Wysokosc(wez.getLeft());
	int prawy=Wysokosc(wez.getRight());
	
	if(lewy>prawy) {
		return lewy+1;
		
	}
	else {
		return prawy+1;
	}
}

public void Menu() {
	System.out.println("Podaj wyra¿enie");
	Scanner sc=new Scanner(System.in);
	String p=sc.nextLine();
	Utworz(l.convert(p));
	
	System.out.println("Menu");
	System.out.println("");
	System.out.println("1.Podaj postaæ infix");
	System.out.println("2.Podaj postaæ postfix");
	System.out.println("3.Podaj wynik wyra¿enia");
	System.out.println("4.Liczba liœci");
	System.out.println("5.Liczba wêz³ów");
	System.out.println("6.Wysokoœæ drzewa");
	System.out.println("7.Chce podaæ nowe wyra¿enie");

	
	while(true) {
		int sw=Integer.parseInt(sc.nextLine());
		switch(sw) {
		case 1:
			PrintInOrder(root);
			break;
		case 2:
			PrintPostOrder(root);
			break;
		case 3:
			System.out.println(Obliczanie(root));
			break;
		case 4:
			Liscie(root);
			System.out.println(counterL);
			counterL=0;
			break;
		case 5:
			Wezly(root);
			System.out.println(counterN);
			counterN=0;
			break;
		case 6:
			System.out.println(Wysokosc(root));
			break;
		case 7:
			Menu();
			break;
	
		
		}
	}
	
}


}

