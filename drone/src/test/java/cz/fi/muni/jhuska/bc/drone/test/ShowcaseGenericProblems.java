package cz.fi.muni.jhuska.bc.drone.test;


public class ShowcaseGenericProblems {
	
	public static void main(String[] args) {
		
		Drawer drawer = new Drawer();
		drawer.addItem("pen");
		
		Integer pen = (Integer) drawer.getItem();
	}

}
