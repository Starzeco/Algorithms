

public class HuffmanTree {
private Node root;
public HuffmanTree() {
	setRoot(null);
}
public HuffmanTree(Node n) {
	root=n;
}

public Node getRoot() {
	return root;
}

public void setRoot(Node root) {
	this.root = root;
}
private void inOrder(Node root) {
	if(root!=null) {
		inOrder(root.getLeft());
		System.out.println(root.toString());
		inOrder(root.getRight());
	}
}
public void inOrder() {
	inOrder(this.root);
}
String lookupResult = "";
private void findPath(String ch, Node node, String path) {
    if (node != null) {
        if (node.getLeft() != null)
            findPath(ch, node.getLeft(), path + '0');
        if (node.getRight()!= null)
            findPath(ch, node.getRight(), path + '1');
        if (node.getLeft() == null && node.getRight() == null && node.getLetters().toString().equals(ch)) {
            lookupResult = path;
        }
    } 
}
public void findPath(String ch) {
	findPath(ch,this.root,"");
}

public void decode(String S)
{
    StringBuilder sb = new StringBuilder();
    Node c = root;
    for (int i = 0; i < S.length(); i++) {
        c = S.charAt(i) == '1' ? c.getRight() : c.getLeft();
        if (c.getLeft() == null && c.getRight() == null) {
            sb.append(c.getLetters());
            c = root;
        }
    }
    System.out.print(sb);
}


}

