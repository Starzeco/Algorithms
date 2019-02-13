
public class Stos<T> implements Stack1<T> {
	private Element<T> head=null;
	
	public class Element<T>{
		private T value;
		private Element<T> next;
		public Element(T value) {
			this.value=value;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public Element<T> getNext() {
			return next;
		}
		public void setNext(Element<T> next) {
			this.next = next;
		}
		
	}
	
	
	
	
	public boolean empty() {
		if(head==null) {
			return true;
		}
		else {return false;}
	}

	
	public T push(T e) {
		Element<T> el=head;
		head=new Element<T>(e);
		head.setNext(el);
		return e;
	}
	public T pop() {
		Element<T> e=head;
		head=head.getNext();
		return e.getValue();
	}
	public T peek() {
		
		return head.getValue();
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	/*public T push(T e) {
	Element<T> elem=new Element<T>(e);
	if(head==null) {
		head=elem;
		return elem.getValue();
	}
	else {
		Element<T> actElem=head;
		while(actElem.getNext()!=null) {
			actElem=actElem.getNext();
		}
		actElem.setNext(elem);
		return actElem.getNext().getValue();
	}
}*/
	
	/*public T pop() {
		if(head==null) {
			System.out.println("Stos pusty");
			return null;
		}
		if(head.getNext()==null) {
			T value1=head.getValue();
			head=null;
			return value1;
		}
		else {
			Element<T> actElem=head;
			while(actElem.getNext().getNext()!=null) {
				actElem=actElem.getNext();
			}
			
			T value=actElem.getNext().getValue();
			actElem.setNext(null);
			return value;
		}
	}

	
	public T peek() {
		if(head==null) {
			System.out.println("Stos pusty");
			return null;
		}
		if(head.getNext()==null) {
			T value1=head.getValue();
			
			return value1;
		}
		else {
			Element<T> actElem=head;
			while(actElem.getNext().getNext()!=null) {
				actElem=actElem.getNext();
			}
			T value=actElem.getNext().getValue();
			return value;
		}
	}*/

}
