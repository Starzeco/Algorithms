
public class Mors {
	private	Node root=new Node(new StringBuffer("s"),0);
	
	
	public void Stworz() {
		Node node = new Node(new StringBuffer("s"),0);
		node.setCode(".");
		node.setLitera("e");
		root.setLeft(node);
		Node node1 = new Node(new StringBuffer("s"),0);
		node1.setCode("-");
		node1.setLitera("t");			// JEMU MUSZE JESZCZE ZROBIC SYNOW
		root.setRight(node1);
		Node node2 = new Node(new StringBuffer("s"),0);
		node2.setCode(".");
		node2.setLitera("i");
		node.setLeft(node2);
		Node node3 = new Node(new StringBuffer("s"),0);
		node3.setCode("-");
		node3.setLitera("a");
		node.setRight(node3);
		Node node4 = new Node(new StringBuffer("s"),0);
		node4.setCode(".");
		node4.setLitera("s");
		node2.setLeft(node4);
		Node node5 = new Node(new StringBuffer("s"),0);
		node5.setCode("-");
		node5.setLitera("u");
		node2.setRight(node5);
		Node node6 = new Node(new StringBuffer("s"),0);
		node6.setCode(".");
		node6.setLitera("h");
		node4.setLeft(node6);
		Node node7 = new Node(new StringBuffer("s"),0);
		node7.setCode("-");
		node7.setLitera("v");
		node4.setRight(node7);
		Node node8 = new Node(new StringBuffer("s"),0);
		node8.setCode(".");
		node8.setLitera("f");
		node5.setLeft(node8);
		Node node9 = new Node(new StringBuffer("s"),0);
		node9.setCode(".");
		node9.setLitera("r");
		node3.setLeft(node9);
		Node node10 = new Node(new StringBuffer("s"),0);
		node10.setCode(".");
		node10.setLitera("l");
		node9.setLeft(node10);
		Node node11 = new Node(new StringBuffer("s"),0);
		node11.setCode("-");
		node11.setLitera("w");
		node3.setRight(node11);
		Node node12 = new Node(new StringBuffer("s"),0);
		node12.setCode(".");
		node12.setLitera("p");
		node11.setLeft(node12);
		Node node13 = new Node(new StringBuffer("s"),0);
		node13.setCode("-");
		node13.setLitera("j");
		node11.setRight(node13);
		Node node14 = new Node(new StringBuffer("s"),0);
		node14.setCode(".");
		node14.setLitera("n");
		node1.setLeft(node14);
		Node node15 = new Node(new StringBuffer("s"),0);
		node15.setCode(".");
		node15.setLitera("d");
		node14.setLeft(node15);
		Node node16 = new Node(new StringBuffer("s"),0);
		node16.setCode(".");
		node16.setLitera("b");
		node15.setLeft(node16);
		Node node17 = new Node(new StringBuffer("s"),0);
		node17.setCode("-");
		node17.setLitera("x");
		node15.setRight(node17);
		Node node18 = new Node(new StringBuffer("s"),0);
		node18.setCode("-");
		node18.setLitera("k");
		node14.setRight(node18);
		Node node19 = new Node(new StringBuffer("s"),0);
		node19.setCode(".");
		node19.setLitera("c");
		node18.setLeft(node19);
		Node node20 = new Node(new StringBuffer("s"),0);
		node20.setCode("-");
		node20.setLitera("y");
		node18.setRight(node20);
		Node node21 = new Node(new StringBuffer("s"),0);
		node21.setCode("-");
		node21.setLitera("m");
		node1.setRight(node21);
		Node node22 = new Node(new StringBuffer("s"),0);
		node22.setCode(".");
		node22.setLitera("g");
		node21.setLeft(node22);
		Node node23 = new Node(new StringBuffer("s"),0);
		node23.setCode(".");
		node23.setLitera("z");
		node22.setLeft(node23);
		Node node24 = new Node(new StringBuffer("s"),0);
		node24.setCode("-");
		node24.setLitera("q");
		node22.setRight(node24);
		Node node25 = new Node(new StringBuffer("s"),0);
		node25.setCode("-");
		node25.setLitera("o");
		node21.setRight(node25);
		
		
		
		}
	
	public void Odczytaj(String pom) {
		char tab[]=pom.toCharArray();
		for(int i=0;i<tab.length;i++) {
			if(tab[i]==' ') {
				System.out.print(" ");
			}
			else {
				Node pomo=root;
				while(tab[i]!=' ') {
					if(tab[i]=='-') {
						pomo=pomo.getRight();
					}
					else {
						pomo=pomo.getLeft();
					}
						
					
					i++;
				}
				System.out.print(pomo.getLitera());
				i--;
			}
		}
		
	}
	
	public void Koduj(String pom) {
		char tab[]=pom.toCharArray();
		
		for(int i=0;i<tab.length;i++) {
			
		}
	}
	
	
			
			
			
}
