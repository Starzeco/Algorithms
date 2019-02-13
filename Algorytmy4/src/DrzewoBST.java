import java.util.Random;



public class DrzewoBST {
	private Wezel<Integer> root=null;
	public Wezel<Integer> getRoot() {
		return root;
	}

	public void setRoot(Wezel<Integer> root) {
		this.root = root;
	}
	int suma=0;
	public void Utworz() {
		Random rand=new Random();
		int k=1;
		while(k!=0) {
			k=rand.nextInt(10);
			Wezel<Integer> pom=new Wezel<Integer>(k);
			if(root==null) {
				root=pom;
			}
			else {
				Wezel<Integer> pom2=root;
				Wezel<Integer> parent=null;
				while(pom2!=null) {
					parent=pom2;
					if(pom2.getValue()>k) {
						pom2=pom2.getLeft();
					}
					else {
						pom2=pom2.getRight();
					}
					
				}
				if(parent.getValue()>k) {
					parent.setLeft(pom);
					parent.getLeft().setParent(parent);
					
				}
				else {
					parent.setRight(new Wezel<Integer>(k));
					parent.getRight().setParent(parent);
				}
			}
			
		}
	}
	
	public int Obliczanie(Wezel<Integer> wez) {
		if(wez==null) {
			return 0;
		}
		return Obliczanie(wez.getLeft())+Obliczanie(wez.getRight());
		
		
		
		
	}
	public void PrintPostOrder(Wezel<Integer> wez) {		// Odwrotna notacja polska
		if(wez!=null) {
			PrintPostOrder(wez.getLeft());
			PrintPostOrder(wez.getRight());
			System.out.print(wez.getValue());
		}
	}
	
}
