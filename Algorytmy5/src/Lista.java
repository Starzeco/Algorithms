
public class Lista<T> {
private Element<T> head=null;
	
	
	

	
public void addNaKoniec(T k) {
	Element <T> newElem=new Element<T>(k);
	if(head==null) {
		head=newElem;
	}
	else{
		
			if(head!=null) {
				Element<T> actElem=head;
				while(actElem.getNext()!=null) {
					actElem=actElem.getNext();
				}
				actElem.setNext(newElem);
				newElem.setPrevious(actElem);
				}	
	}
}
public void addIndex(int index,T k) {  
	Element<T> e=new Element<T>(k);
	if(index==0) {
		e.setNext(head);
		head.setPrevious(e);
		head=e;
		
		
	}
	else{
		Element<T> e2=getElement(index-1);
		Element<T> e3=getElement(index);
		if(e2==null) {
		System.out.println("b³¹d");
		}
		if(e3==null) {
			e2.setNext(e);
			e.setPrevious(e2);
		}
		
		else{	
			e3.setPrevious(e);
		
			e.setPrevious(e2);
			e.setNext(e2.getNext());
			e2.setNext(e);
		}
		}
}

public Element<T> getHead() {
	return head;
}
public void setHead(Element<T> head) {
	this.head = head;
}
public int indexOf(T k) {
	int pos=0;
	Element<T> actElem=head;
	while(actElem!=null){
		
		if(actElem.getValue()==k) {
			return pos;}
		pos++;
		actElem=actElem.getNext();
		}
	System.out.println("hej");
	return -1;}

public Element<T> getElement(int index) {
	Element<T> actElement=head;
	while(index>0 && actElement!=null) {
		index--;
		actElement=actElement.getNext();
		
	}
	return actElement;
}
public boolean isEmpty() {
	return head==null;
}
public void wyswietl() {
	if(head==null) {
		System.out.println("Kolejka pusta");
	}
	//System.out.println("Czemu nie dzia³am");
	Element<T> actElem=head;
	while(actElem!=null) {
	System.out.println(actElem.getValue());
	//System.out.println("Skoro powinienem");
	actElem=actElem.getNext();
	
}
	
}

public int size() {
		int pos=0;
		Element<T> actElement=head;
		while(actElement!=null) {
			pos++;
			actElement=actElement.getNext();
		}
		//System.out.println(pos);
		return pos;
	}



}
