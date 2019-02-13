import java.util.NoSuchElementException;

public class Iter implements Iterator<Student> {
	private Student tab[];
	private int poz=0;
	public Iter(Student tab[]) {
		this.tab=tab;
	}
	@Override
	public boolean hastNext() {
		return poz<tab.length;
	}

	@Override
	public Student next()throws NoSuchElementException {
		if(hastNext()) {
			return tab[poz++];
		}else throw new NoSuchElementException();
	}
	@Override
	public void previous() {
		poz--;
		
	}
	@Override
	public void first() {
	poz=0;
		
	}
	@Override
	public void last() {
		if(poz>0) {
		poz=tab.length-1;}
	} 
	
	/*public void UsunDuplikat() {
	ItArray it=new ItArray(array);
	while(it.hasNext()) {
		int e=array.indexOf(it.next1());
		Karta elem=array.get(e);
		if(e<array.size()-1) {
		Karta elem2=array.get(++e);
		if(elem.getWartosc()==elem2.getWartosc() && elem.getKolor()==elem2.getKolor()) {
			array.remove(e);
		}
	}
	}	
}*/
}
