import java.util.ArrayList;

public class Wezel {
private String value;
private Wezel parent;
private Wezel left;
private Wezel right;
private String kolor;
private ArrayList<Integer> list;

public Wezel(String value) {
	this.value=value;
	list=new ArrayList<Integer>();
	//this.kolor="hej";
}

public String getValue() {
	return value;
}

public void setValue(String value) {
	this.value = value;
}

public Wezel getParent() {
	return parent;
}

public void setParent(Wezel parent) {
	this.parent = parent;
}

public Wezel getLeft() {
	return left;
}

public void setLeft(Wezel left) {
	this.left = left;
}

public Wezel getRight() {
	return right;
}

public void setRight(Wezel right) {
	this.right = right;
}

public String getKolor() {
	return kolor;
}

public void setKolor(String kolor) {
	this.kolor = kolor;
}

public ArrayList<Integer> getList() {
	return list;
}

public void setList(ArrayList<Integer> list) {
	this.list = list;
}


	
	
}
