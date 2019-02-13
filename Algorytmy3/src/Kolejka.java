
public class Kolejka <T> implements Queue1<T> {
	
	private int size=0;
	private KolejkaNode<T> head=null;
	private int maxsize=3;
	
	public int getMaxsize() {
		return maxsize;
	}



	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}



	public Kolejka(){};
	
	
	
	public KolejkaNode<T> getHead() {
		return head;
	}


	public void setHead(KolejkaNode<T> head) {
		this.head = head;
	}



	public class KolejkaNode<T>{
		private T value;
		private KolejkaNode<T> next;
		public KolejkaNode(T value, KolejkaNode<T> next) {
			this.value=value;
			this.next=next;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T value) {
			this.value = value;
		}
		public KolejkaNode<T> getNext() {
			return next;
		}
		public void setNext(KolejkaNode<T> next) {
			this.next = next;
		}
		
		
	}
	
	public KolejkaNode<T> getNode(String value){
		
		KolejkaNode<T> nodeToGet=head;
		
		if(head.getValue().equals(value)) {
			return head;
		}
		else {
		while(nodeToGet!=null && !nodeToGet.getValue().equals(value)) {
			
			nodeToGet=nodeToGet.getNext();
		}
		}
		return nodeToGet;
		
		
	}
	@Override
	public void insert(T value) {
		KolejkaNode<T> p=new KolejkaNode<T>(value,null);
		if(head==null) {
			head=p;
			size++;
		}
		else{
			KolejkaNode<T> actElem=head;
			while(actElem.getNext()!=null) {
				actElem=actElem.getNext();
			}
			actElem.setNext(p);
			size++;
		}
		
	}

	
	public void remove() {
		if(head==null) {
			System.out.println("Pusta kolejka");
		}
		if(head!=null) {
			/*if(head.getNext()==null) {
				head=null;
				size--;
			}*/
			if(head.getNext()!=null) {
				KolejkaNode<T> actElem=head.getNext();
				head=actElem;
				size--;
				
			}
			else {
				head=null;
				size--;
			}
			
		}
		
	}

	
	public boolean isEmpty() {
		return size==0;
	}

	
	public boolean isFull() {
		return size==maxsize;
	}
	public void wyswietl() {
		if(head==null) {
			
		}
		KolejkaNode<T> actElem=head;
		while(actElem!=null) {
			System.out.println(actElem.getValue());
			actElem=actElem.getNext();
		}
	}
	
	public KolejkaNode<T> findeNode(int index){
		KolejkaNode<T> nodeToFind=head;
		for(int i=1;i<=index;i++) {
			nodeToFind=nodeToFind.getNext();
		}
		return nodeToFind;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}

}
