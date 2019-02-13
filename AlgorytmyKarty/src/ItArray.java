import java.util.NoSuchElementException;
import java.util.ArrayList;

public class ItArray implements IteratorArray {
	private ArrayList<Karta>array;
	int pos=0;
	
	public ItArray(ArrayList<Karta>array) {
		this.array=array;
	}
	
	@Override
	public boolean isDone() {
		return (pos>(array.size()-1))||(pos<0);
	}

	@Override
	public void next() {
		pos++;
	}
	@Override
	public void previous() {
		pos--;
		
	}
	@Override
	public void first() {
	pos=0;
		
	}
	@Override
	public void last() {
		pos=array.size()-1;
	}

	@Override
	public Karta current() {
		return array.get(pos);
	} 
	@Override
	public boolean hasNext() {
		
		return pos<array.size();
		
	}
	@Override
	public Karta next1()throws NoSuchElementException {
		if(hasNext()) {
			
			return array.get(pos++);
		}else throw new NoSuchElementException();
	}
	
}
