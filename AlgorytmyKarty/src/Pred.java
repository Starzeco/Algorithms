
public class Pred implements Predicate{
public boolean Wiekszy(int k) {
	Karta karta=new Karta();
	return k>karta.getWartosc();
}
}
