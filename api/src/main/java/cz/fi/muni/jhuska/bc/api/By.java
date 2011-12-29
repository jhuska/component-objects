package cz.fi.muni.jhuska.bc.api;

public abstract class By {

	public static By className(final String className) {
		
		return new ByClassName(className);
	}
	
	public static class ByClassName extends By {
		
		private final String className;
		
		public ByClassName(String className) {
			this.className = className;
		}
	}
}
