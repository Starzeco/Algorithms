

public class Wezel<T> {
	private T value;
	private Wezel<T> left;
	private Wezel<T> right;
	private Wezel<T> parent;
	
	public Wezel(T value) {
		this.value=value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Wezel<T> getLeft() {
		return left;
	}
	public void setLeft(Wezel<T> left) {
		this.left = left;
	}
	public Wezel<T> getRight() {
		return right;
	}
	public void setRight(Wezel<T> right) {
		this.right = right;
	}
	public Wezel<T> getParent() {
		return parent;
	}
	public void setParent(Wezel<T> parent) {
		this.parent = parent;
	}
}
