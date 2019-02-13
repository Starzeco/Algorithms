


public class Node implements Comparable<Node>{
	private Node left=null;
	private Node right=null;
	private StringBuffer letters;
	private int priority;
	private String code;
	private String litera;
	public Node(StringBuffer letters,int priority) {
		this.letters=letters;
		this.priority=priority;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setLitera(String litera) {
		this.litera=litera;
	}
	public String getLitera() {
		return litera;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public StringBuffer getLetters() {
		return letters;
	}

	public void setLetters(StringBuffer letters) {
		this.letters = letters;
	}
	@Override
	public int compareTo(Node n) {
		int ret= this.priority-n.getPriority();
		if(ret==0) {
			return letters.toString().compareTo(n.letters.toString());
		}
		else {
			return ret;
		}
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	public boolean equals(Object node) {
		return letters.toString().equals(((Node) node).getLetters().toString());
	}
	public String toString() {
		return String.format("%-5s -%d%5s", letters.toString(),priority,code);
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
}

