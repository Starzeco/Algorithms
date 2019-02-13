
public class Element<T>{
		private T value;
		private Element<T> next;
		private Element<T> previous;
		
		public Element(T value) {
			this.value=value;
		
			}
		public Element<T> getNext() {
			return next;
		}
		public void setNext(Element<T> e) {
			next=e;
		}
		public Element<T> getPrevious() {
			return previous;
		}
		public void setPrevious(Element<T> e) {
			previous=e;
		}
		public T getValue() {
			return value;
		}
		public void setValue(T e) {
			value=e;
		}
		public void InsertAfter(Element<T> e) {
			e.setNext(this.getNext());
			e.setPrevious(this);
			this.getNext().setPrevious(e);
			this.setNext(e);
		}
		public void InsertBefore(Element<T> e) {
			e.setNext(this);
			e.setPrevious(this.getPrevious());
			this.getPrevious().setNext(e);
			this.setPrevious(e);
		}
		public void remove() {
			this.getNext().setPrevious(this.getPrevious());
			this.getPrevious().setNext(this.getNext());
		}
	}
