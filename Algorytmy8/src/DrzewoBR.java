import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;


public class DrzewoBR {
private Wezel root=null;


public void Insert(String slowo,int poziom) {
	boolean kolorowanie=true;
	Wezel pom=new Wezel(slowo);
	if(root==null) {
		root=pom;
		root.getList().add(poziom);
		
	}
	else {
		Wezel actual=root;
		Wezel parent=null;
		while(actual!=null) {
			parent=actual;
			
			
			if((actual.getValue()).compareTo(slowo)<0) {		
				actual=actual.getRight();
				
				
			}
			
			else{
				if((actual.getValue()).compareTo(slowo)>0) {
				actual=actual.getLeft();
			}
				else {
					actual.getList().add(poziom);
					kolorowanie=false;
					break;
			}
			}
			
		}
		if((parent.getValue()).compareTo(slowo)<0) {
			parent.setRight(pom);
			pom.getList().add(poziom);
			pom.setParent(parent);
		}
		else {
			if((parent.getValue()).compareTo(slowo)>0) {
			parent.setLeft(pom);
			pom.getList().add(poziom);
			pom.setParent(parent);
			}
			else {
				
			}
		}
		
	}
	//Tu zaczyna siê algorytm czerwono czarnego 
	//pom.setKolor("czerwony");
	if(kolorowanie) {
		pom.setKolor("czerwony");
		while(pom!=root && pom.getParent().getKolor().equals("czerwony")) {
			if(pom.getParent()==pom.getParent().getParent().getLeft()) {
				Wezel y=pom.getParent().getParent().getRight();
				if(y!=null) {
					if(y.getKolor().equals("czerwony")) {
						pom.getParent().setKolor("czarny");
						y.setKolor("czarny");
						pom.getParent().getParent().setKolor("czerwony");
						pom=pom.getParent().getParent();
					}
				}
				else {
					if(pom==pom.getParent().getRight()) {
						pom=pom.getParent();
						LeftRotate(pom);
					}
					pom.getParent().setKolor("czarny");
					pom.getParent().getParent().setKolor("czerwony");
					RightRotate(pom.getParent().getParent());
				}
			}
			else {
				Wezel y=pom.getParent().getParent().getLeft();
				if(y!=null) {
					if(y.getKolor().equals("czerwony")) {
						pom.getParent().setKolor("czarny");
						y.setKolor("czarny");
						pom.getParent().getParent().setKolor("czerwony");
						pom=pom.getParent().getParent();
					}	
				}
				else {
					if(pom==pom.getParent().getLeft()) {			// Tutaj nie jestem pewien czy na pewno zmieniac lefty na righty i czy rotaty tez zmieniac
						pom=pom.getParent();
						RightRotate(pom);
					}
					pom.getParent().setKolor("czarny");
					pom.getParent().getParent().setKolor("czerwony");
					LeftRotate(pom.getParent().getParent());
				}
			}
			
		}
		root.setKolor("czarny");
		
					
	}	
	
	
}

public void PrintInOrder(Wezel wez) {		
	if(wez!=null) {
		
		PrintInOrder(wez.getLeft());
		
		System.out.print(wez.getValue());
		System.out.print("     -");
		for(Integer i:wez.getList()) {
			System.out.print(i+",");
		}
		System.out.println("");
		PrintInOrder(wez.getRight());
		
	}
}

public void Kolory(Wezel wez) {
	if(wez!=null) {
		Kolory(wez.getLeft());
		System.out.println(wez.getKolor());
		Kolory(wez.getRight());
	}
}

public Wezel getRoot() {
	return root;
}

public void LeftRotate(Wezel wez) {
	Wezel y=wez.getRight();
	wez.setRight(y.getLeft());
	if(y.getLeft()!=null) {
		y.getLeft().setParent(wez);
	}
	y.setParent(wez.getParent());
	if(wez.getParent()==null) {		
		root=y;
	}
	else {				
		if(wez==wez.getParent().getLeft()) {
			wez.getParent().setLeft(y);
		}
		else {
			wez.getParent().setRight(y);
		}
	}
	y.setLeft(wez);
	wez.setParent(y);
	
	
}
public void RightRotate(Wezel wez) {
	Wezel y=wez.getLeft();
	wez.setLeft(y.getRight());
	if(y.getRight()!=null) {
		y.getRight().setParent(wez);
	}
	y.setParent(wez.getParent());
	if(wez.getParent()==null) {
		root=y;
	}
	else {
		if(wez==wez.getParent().getRight()) {
			wez.getParent().setRight(y);
		}
		else {
			wez.getParent().setLeft(y);
		}
	}
	y.setRight(wez);
	wez.setParent(y);
}

public void LevelOrder() {
	Queue<Wezel> queue = new LinkedList<Wezel>();
    queue.add(root);
    while (!queue.isEmpty()) 
    {

        // poll() removes the present head.
       
        Wezel tempNode = queue.poll();
        System.out.print(tempNode.getValue() + " ");

        //Enqueue left child 
        if (tempNode.getLeft() != null) {
            queue.add(tempNode.getLeft());
        }

        //Enqueue right child 
        if (tempNode.getRight() != null) {
            queue.add(tempNode.getRight());
        }
    }
}
public void Kolory2() {
	Queue<Wezel> queue = new LinkedList<Wezel>();
    queue.add(root);
    while (!queue.isEmpty()) 
    {

        // poll() removes the present head.
       
        Wezel tempNode = queue.poll();
        System.out.print(tempNode.getKolor() + " ");

        //Enqueue left child 
        if (tempNode.getLeft() != null) {
            queue.add(tempNode.getLeft());
        }

        //Enqueue right child 
        if (tempNode.getRight() != null) {
            queue.add(tempNode.getRight());
        }
    }
}
private Wezel max(Wezel node) {
while(node.getRight() != null)
node = node.getRight();
return node;
}

public void czytaj() {
	try(BufferedReader reader=new BufferedReader(new FileReader("tekst.txt"))){
		String line="";
		int counter=1;
		while(true) {
			line=reader.readLine();
			if(line==null) {
				break;
			}
			line=line.replace(",","");
			line=line.replace("-", "");
			line=line.replace(".", "");
			//System.out.println(line);
			String arr[]=line.split(" ");
			for(String str:arr) {
				Insert(str,counter);
			}
			counter++;
			
		}
		
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public Wezel search(String key) {
	Wezel actual=root;
	while(actual!=null && actual.getValue()!=key) {
		if((actual.getValue()).compareTo(key)>0) {
			actual=actual.getLeft();
		}
		if((actual.getValue()).compareTo(key)<0){
			actual=actual.getRight();
		}
	}
	return actual;
			
		
	}
private Wezel successor(String key) {
	Wezel node = this.search(key);     
// Szukanie nastêpnika gdy wêze³ ma prawego potomka
if(node.getRight() != null) {           
	node = node.getRight();
	while(node.getLeft() != null) {
		
	
		node = node.getLeft();
	}
return node;
}
// Szukanie nastêpnika gdy wêze³ nie ma prawgo potomka
else { if(node.getRight() == null && node != root && node != this.max(root)) {
Wezel parent = node.getParent();
while(parent != root && (parent.getValue().compareTo(node.getValue())<0)){
		parent = parent.getParent();
		}
return parent;
}


}

return null;
}

public Wezel delete(Wezel r,String key) {
	Wezel p,p2,n;
	if(root.getValue()==key) {
		Wezel lt,rt;
		lt=root.getLeft();
		rt=root.getRight();
		if(lt==null && rt==null) {
			return null;
		}
		else {
			if(lt==null) {
				p=rt;
				return p;
			}
			else {
				if(rt==null) {
					p=lt;
					return p;
				}
				else {
					p2=rt;
					p=rt;
					while(p.getLeft()!=null) {
						p=p.getLeft();
					}
					p.setLeft(lt);
					return p2;
				}
			}
			
		}
		
	}
	if(key.compareTo(root.getValue())<0) {
		n=delete(root.getLeft(),key);
		root.setLeft(n);
	}
	else {
		n=delete(root.getRight(),key);
		root.setRight(n);
	}
	return root;
	
	
}
public String minValue(Wezel root)
{
    String minv = root.getValue();
    while (root.getLeft() != null)
    {
        minv = root.getLeft().getValue();
        root = root.getLeft();
    }
    return minv;
}



/* A recursive function to insert a new key in BST */


public void usun(String s) {
	//Wezel pom=new Wezel(s);
	Wezel pom2=search(s);
	Wezel parent=pom2.getParent();
	if(pom2.getRight()==null && pom2.getLeft()==null) {
		if(pom2==parent.getLeft()) {
			pom2.setParent(null);
			parent.setLeft(null);
		}
		else {
			pom2.setParent(null);
			parent.setRight(null);
		}
	}else {
		Wezel nastepnik=successor(s);
		if(pom2.getLeft()!=null && pom2.getRight()==null) {
			pom2.getLeft().setParent(nastepnik);
			nastepnik.setLeft(pom2.getLeft());
			
		}
		if(pom2.getLeft()==null && pom2.getRight()!=null) {
			pom2.getRight().setParent(nastepnik);
			nastepnik.setLeft(pom2.getRight());
		}
		else {
			nastepnik.setLeft(pom2.getLeft());
			pom2.getLeft().setParent(nastepnik);
			nastepnik.setRight(pom2.getRight());
			pom2.getRight().setParent(nastepnik);
			
			pom2.setLeft(null);
			pom2.setRight(null);
			
		}
	
	
	
}
}

}
