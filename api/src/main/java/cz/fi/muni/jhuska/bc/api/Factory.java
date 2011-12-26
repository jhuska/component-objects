package cz.fi.muni.jhuska.bc.api;

import java.lang.reflect.Field;
import java.nio.channels.IllegalSelectorException;


public class Factory {

	/**
	 * 
	 * @param clazz
	 * @return
	 * @param <T>
	 *            the final implementation of component
	 */
	public static <T extends AbstractComponent> T initializeComponent(Class<T> clazz) {
		AbstractComponent component = instantiateComponent(clazz);
		
		// TODO read fields of component class and obtain root types and other elements
		Field[] declaredFields = clazz.getDeclaredFields();
		
		// TODO initialize root
		RootReference rootReference = component.getRootReference();
		
		// TODO initialize other elements
		
		return null;
	}
	
	public static <T extends AbstractComponent> T instantiateComponent(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			throw new IllegalSelectorException();
		}
	}
}
