package cz.fi.muni.jhuska.bc.drone.test;

public class GenericDrawer<T> {

	private T item;

	public void addItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return this.item;
	}
}
