package cz.fi.muni.jhuska.bc.drone.test;

public class Drawer {
	private Object item;
	
	public void addItem(Object item) {
		this.item = item;
	}
	
	public Object getItem() {
		return this.item;
	}
}