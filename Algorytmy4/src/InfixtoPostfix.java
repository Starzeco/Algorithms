

public class InfixtoPostfix {
private Stos<Character> k;
private Stos<Integer> k2;
private Stos<Character> k3;
private Stos<Character> k4;
//private Stos<Wezel<Character>> stos;

private String postfix;

public String convert(String infix) {
	k=new Stos<Character>();
	postfix=" ";
	
	char [] tab=infix.toCharArray();
	for(int i=0;i<tab.length;i++) {
		
		if(Character.isDigit(tab[i])) {
			postfix=postfix+Character.toString(tab[i]);
			
		}
		
		else { 
			if(isOperator(tab[i])){
				
			proccessOperator(tab[i]);
				if(tab[i]!=')' && tab[i]!='(') {
					postfix=postfix+" ";
				}	
				}
			else {
				System.out.println("B³¹d, coœ jest zle wpisane");
				
			}
			
			/*while(!k.empty()) {
				postfix=postfix+Character.toString(k.pop());
			}*/
		/*	char j=k.pop();
			postfix=postfix+Character.toString(j); */ 
			
		}
		
		
	}
	while(!k.empty()) {
		//postfix=postfix+" "; //Próba
		postfix=postfix+Character.toString(k.pop());
	}										
	return postfix;				
}								


private void proccessOperator(char op) {
	char topOp;
	if(k.empty() || op=='(') {
		k.push(op);
	}
	else {
		topOp=k.peek();
		if(precedence(op)>precedence(topOp)) {
			k.push(op);
		}
		else {
			while(!k.empty() && precedence(op)<=precedence(topOp)) {
				char p=k.pop();
				if(topOp=='(') {
					break;
				}
				
				postfix=postfix+Character.toString(p);
				
				
				
				if(!k.empty()) {
					topOp=k.peek();
				}
				/*if(op!=')') {
					k.push(op);		
				}*/
			}
			if(op!=')') {
				k.push(op);		
			}
		}
	}
}
private int precedence(char op) {
	if(op=='+' || op=='-') { return 1;}
	if(op=='*'||op=='/'|| op=='%') {return 2;}
	if(op=='('||op==')') {return -1;}
	return 0;
}
public boolean isOperator(char op) {
	if(op=='+' || op=='-'|| op=='*'||op=='/'|| op=='('||op==')'|| op=='%') {
		return true;
	}
	else {return false;}
}


public int przeliczanie2(String y) {
	k2=new Stos<Integer>();
	char [] tab1=y.toCharArray();
	for(int i=0;i<tab1.length;i++) {
		if(tab1[i]==' ') {
			i++;
			String pom="";
			if(Character.isDigit(tab1[i])) {
				while(Character.isDigit(tab1[i])) {
					pom=pom+Character.toString(tab1[i]);
					i++;
				
				}
				if(tab1[i]==' ') {
					i--;
				}
				int p=Integer.parseInt(pom);
				k2.push(p);
			}
			else {
				
			}
			
			//konwersja stringa do inta i pushniecie 
		}
		if(isOperator(tab1[i])) {
			int a=k2.pop();
			//System.out.println(a);
			int b=k2.pop();
			char c=tab1[i];
			if(c=='+') {
				int d=b+a;
				k2.push(d);
			}
			if(c=='-') {
				int u=b-a;
				k2.push(u);
			}
			if(c=='*') {
				int j=b*a;
				k2.push(j);
			}
			if(c=='/') {
				if(a==0) {
					System.out.println("Dzielisz przez zero");
					
					return -1;
				}
				else {	int h=b/a;
				k2.push(h);
				}
			}
			if(c=='%') {
				int o=b%a;
				k2.push(o);
			}
		}
		
		
		
	}
	int r=k2.pop();
	return r;
	
	
}

public void Sprawdz(String k) {
	k3=new Stos<Character>();
	char [] tab=k.toCharArray();
	String p="";
	String s="";
	for(int i=0;i<tab.length;i++) {
		k3.push(tab[i]);
		p=p+tab[i];
	}
	while(!k3.empty()) {
		s=s+k3.pop();
	}
	if(p.equals(s)) {
		System.out.println("To jest palindrom");
	}
	else {
		System.out.println("Nie jest");
	}
}




















}
