
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HuffmanCoding {
private static PriorityQueue<Node> priorytetowa = new PriorityQueue<Node>();
private static ArrayList<Node> wystapienia = new ArrayList<Node>();
public static HuffmanTree createHuffmanTree(String text) {
	
ArrayList<String> used = new ArrayList<String>();
String textArr[]=text.split("");
for(int i=0;i<textArr.length;i++) {
	String s=textArr[i];
	if(!used.contains(s)) {
		int counter=0;
		for(int j=0;j<textArr.length;j++) {
			if(textArr[j].equals(s)) {
				counter++;
			}
		}
		used.add(s);
		Node node = new Node(new StringBuffer(s),counter);
		wystapienia.add(node);
		priorytetowa.add(node);
		}
	}

while(priorytetowa.size()>1) {
Node node1=priorytetowa.poll();
Node node2=priorytetowa.poll();
		
Node biggerNode=new Node(new StringBuffer(node1.getLetters().toString()+node2.getLetters().toString()),node1.getPriority()+node2.getPriority());
biggerNode.setLeft(node1);
biggerNode.setRight(node2);
priorytetowa.add(biggerNode);
}
HuffmanTree tree = new HuffmanTree(priorytetowa.poll());
return tree;
}
public static ArrayList<Node> createListWithCodes(HuffmanTree tree) {
	for(int i=0;i<wystapienia.size();i++) {
		tree.findPath(wystapienia.get(i).getLetters().toString());
		wystapienia.get(i).setCode(tree.lookupResult);
	}
	return wystapienia;
}
public static  String codeMessage(String text) {
String s[] = text.split("");
StringBuffer ret= new StringBuffer("");
for(int i=0;i<s.length;i++) {
	for(int j=0;j<wystapienia.size();j++) {
		if(s[i].equals(wystapienia.get(j).getLetters().toString())) {
			ret.append(wystapienia.get(j).getCode());
			}
		}
	}
	return ret.toString();
}
public void Zapisz(String p) {
	try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("filePath.txt"))){
		bufferedWriter.write(p);
		
		
	}catch(IOException e) {
		e.printStackTrace();
	}
}


public static void main(String[] args) {
	 HuffmanCoding cod=new HuffmanCoding();
	HuffmanTree tree = createHuffmanTree("ala ma lale");
	ArrayList<Node> list = createListWithCodes(tree);
	for(int i=0;i<list.size();i++) {
		System.out.println(list.get(i));
	}
	System.out.println("");
	System.out.println(codeMessage("ala ma lale"));
	cod.Zapisz(codeMessage("ala ma lale"));
	Mors mo=new Mors();
	tree.decode(codeMessage("ala ma lale"));
	mo.Stworz();
	System.out.println("");
	mo.Odczytaj("- --- .--. ... . -.-. .-. . - ... --- ... ");
	
	
}



}
